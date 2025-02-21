package com.week4.prod_ready_features.com.week4.prod_ready_features.controller;

import com.week4.prod_ready_features.com.week4.prod_ready_features.dto.PostDto;
import com.week4.prod_ready_features.com.week4.prod_ready_features.service.PostService;
import com.week4.prod_ready_features.com.week4.prod_ready_features.service.PostServiceImp;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/posts")
public class PostController {


    private final PostService postService;


    public PostController(PostService postService) {
        this.postService = postService;
    }


    @GetMapping("/all")
    public List<PostDto> getAllPosts(){
        return postService.getAllPosts();
    }



    @PostMapping("")
    public PostDto createNewPost(@RequestBody PostDto inputDto){
        return postService.createNewPost(inputDto);
    }

    @GetMapping("/{postId}")
    public PostDto getPostById(@PathVariable Long postId){
        return postService.getPostById(postId);
    }

    @PutMapping("/{postId}")
    public PostDto updatePost(@PathVariable Long postId, @RequestBody PostDto inputDto){
        return postService.updatePost(postId,inputDto);
    }




}
