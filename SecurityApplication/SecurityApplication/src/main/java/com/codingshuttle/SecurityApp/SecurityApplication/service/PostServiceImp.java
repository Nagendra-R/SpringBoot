package com.codingshuttle.SecurityApp.SecurityApplication.service;


import com.codingshuttle.SecurityApp.SecurityApplication.dto.PostDto;
import com.codingshuttle.SecurityApp.SecurityApplication.entites.PostEntity;
import com.codingshuttle.SecurityApp.SecurityApplication.entites.UserEntity;
import com.codingshuttle.SecurityApp.SecurityApplication.exceptions.ResourceNotFoundException;
import com.codingshuttle.SecurityApp.SecurityApplication.repositories.PostRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class PostServiceImp implements PostService {

    private final PostRepository postRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<PostDto> getAllPosts() {
        return postRepository
                .findAll()
                .stream()
                .map(postEntity -> modelMapper.map(postEntity, PostDto.class))
                .toList();
    }

    @Override
    public PostDto createNewPost(PostDto inputDto) {
        PostEntity postEntity = modelMapper.map(inputDto, PostEntity.class);
        return modelMapper.map(postRepository.save(postEntity), PostDto.class);
    }

    @Override
    public PostDto getPostById(Long postId) {
        UserEntity user = (UserEntity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        log.info("User: {}",user);
        PostEntity postEntity = postRepository.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post not found with id " + postId));
        return modelMapper.map(postEntity, PostDto.class);
    }

    @Override
    public PostDto updatePost(Long postId, PostDto inputDto) {
        PostEntity olderPostEntity = postRepository.findById(postId).orElseThrow(() -> new RuntimeException("Post not found with id " + postId));
        modelMapper.map(inputDto, olderPostEntity);
        PostEntity updatedPostEntity = postRepository.save(olderPostEntity);
        return modelMapper.map(updatedPostEntity, PostDto.class);
    }
}
