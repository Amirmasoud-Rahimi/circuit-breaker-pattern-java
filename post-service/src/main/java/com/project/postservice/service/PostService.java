package com.project.postservice.service;

import com.project.postservice.model.Post;
import com.project.postservice.repository.PostRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public Post findPostByUserId(int userId) {
        return postRepository.findByUserId(userId).orElseThrow(()->new EntityNotFoundException("Post Not Found for User: "+userId));
    }
}