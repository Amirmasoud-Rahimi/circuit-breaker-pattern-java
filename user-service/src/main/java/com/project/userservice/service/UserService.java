package com.project.userservice.service;

import com.project.userservice.dto.PostDto;
import com.project.userservice.model.FailureResponse;
import com.project.userservice.model.Response;
import com.project.userservice.model.SuccessResponse;
import com.project.userservice.model.User;
import com.project.userservice.repository.UserRepository;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final RestTemplate restTemplate;
    private static final String SERVICE_NAME = "user-service";
    private static final String POST_SERVICE_URL = "http://localhost:7070/post/";


    public UserService(UserRepository userRepository, RestTemplate restTemplate) {
        this.userRepository = userRepository;
        this.restTemplate = restTemplate;
    }

    @CircuitBreaker(name = SERVICE_NAME, fallbackMethod = "fallbackMethod")
    public Response getUserByUserId(Integer userId) {
        SuccessResponse response = new SuccessResponse();
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User Not Found: " + userId));
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<PostDto> entity = new HttpEntity<>(null, headers);
        ResponseEntity<PostDto> apiResponse = restTemplate.exchange(
                (POST_SERVICE_URL + user.getId()), HttpMethod.GET, entity,
                PostDto.class);
        PostDto postDto = apiResponse.getBody();
        response.setName(user.getName());
        response.setEmail(user.getEmail());
        response.setPhone(user.getPhone());
        response.setUsername(user.getUsername());
        response.setWebsite(user.getWebsite());
        if (postDto != null) {
            response.setPostBody(postDto.getBody());
            response.setPostTitle(postDto.getTitle());
        }
        return response;
    }

    private Response fallbackMethod(Exception e) {
        return new FailureResponse("Post service is not responding properly! Please Wait...");
    }
}