package com.week4.prod_ready_features.com.week4.prod_ready_features.service;


import com.week4.prod_ready_features.com.week4.prod_ready_features.dto.PostDto;
import com.week4.prod_ready_features.com.week4.prod_ready_features.entites.PostEntity;
import com.week4.prod_ready_features.com.week4.prod_ready_features.exceptions.ResourceNotFoundException;
import com.week4.prod_ready_features.com.week4.prod_ready_features.repository.PostRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImp implements PostService {

    private final PostRepository postRepository;
    private final ModelMapper modelMapper;

    public PostServiceImp(PostRepository postRepository, ModelMapper modelMapper) {
        this.postRepository = postRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public List<PostDto> getAllPosts() {
        return postRepository.findAll().stream().map(postEntity -> modelMapper.map(postEntity, PostDto.class)).toList();
    }

    @Override
    public PostDto createNewPost(PostDto inputDto) {
        PostEntity postEntity = modelMapper.map(inputDto, PostEntity.class);
        return modelMapper.map(postRepository.save(postEntity), PostDto.class);
    }

    @Override
    public PostDto getPostById(Long postId) {
        PostEntity postEntity = postRepository.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post not found with id " + postId));
        return modelMapper.map(postEntity, PostDto.class);
    }

    @Override
    public PostDto updatePost(Long postId, PostDto inputDto) {
        PostEntity olderPostEntity = postRepository.findById(postId).orElseThrow(() -> new RuntimeException("Post not found with id " + postId));
//        System.out.println(olderPostEntity.toString());
//        olderPostEntity.
        modelMapper.map(inputDto, olderPostEntity);
        PostEntity updatedPostEntity = postRepository.save(olderPostEntity);
        return modelMapper.map(updatedPostEntity, PostDto.class);
    }
}
