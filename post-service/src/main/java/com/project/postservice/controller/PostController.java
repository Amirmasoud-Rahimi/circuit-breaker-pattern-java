package com.project.postservice.controller;

import com.project.postservice.model.Post;
import com.project.postservice.service.PostService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {
    private final PostService postService;

    private static boolean serviceIsDown;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/{userId}")
    public Post getByUserId(@PathVariable Integer userId) {
        if (serviceIsDown) {
            throw new RuntimeException("Service Is Down! Please Wait");
        }
        return postService.findPostByUserId(userId);
    }

    @PostMapping("/serviceStatus")
    public void setServiceStatus(@RequestParam boolean status) {
        serviceIsDown = status;
    }
}