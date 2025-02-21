package com.week4.prod_ready_features.com.week4.prod_ready_features.service;


import com.week4.prod_ready_features.com.week4.prod_ready_features.dto.PostDto;

import java.util.List;



public interface PostService {

    List<PostDto> getAllPosts();

    PostDto createNewPost(PostDto inputDto);

    PostDto getPostById(Long postId);

    PostDto updatePost(Long postId, PostDto inputDto);
}
