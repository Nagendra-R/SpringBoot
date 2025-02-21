package com.codingshuttle.SecurityApp.SecurityApplication.service;


import com.codingshuttle.SecurityApp.SecurityApplication.dto.PostDto;

import java.util.List;


public interface PostService {

    List<PostDto> getAllPosts();

    PostDto createNewPost(PostDto inputDto);

    PostDto getPostById(Long postId);

    PostDto updatePost(Long postId, PostDto inputDto);
}
