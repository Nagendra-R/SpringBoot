package com.codingshuttle.SecurityApp.SecurityApplication.controllers;

import com.codingshuttle.SecurityApp.SecurityApplication.dto.PostDto;
import com.codingshuttle.SecurityApp.SecurityApplication.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/posts")
public class PostController {

    private final PostService postService;

    @GetMapping("/all")
    public List<PostDto> getAllPosts() {
        return postService.getAllPosts();
    }

    @PostMapping("")
    public PostDto createNewPost(@RequestBody PostDto inputDto) {
        return postService.createNewPost(inputDto);
    }

    @GetMapping("/{postId}")
    public PostDto getPostById(@PathVariable Long postId) {
        return postService.getPostById(postId);
    }

    @PutMapping("/{postId}")
    public PostDto updatePost(@PathVariable Long postId, @RequestBody PostDto inputDto) {
        return postService.updatePost(postId, inputDto);
    }


}
