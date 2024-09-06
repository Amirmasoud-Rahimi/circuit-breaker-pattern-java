package com.project.postservice.configuration;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.postservice.model.Post;
import com.project.postservice.repository.PostRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Configuration;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Configuration
public class DataSetup {
    private final PostRepository postRepository;

    public DataSetup(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @PostConstruct
    public void setData() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonNode = mapper.readTree(new File("src/main/resources/posts.json"));
        List<Post> postList = mapper.readValue(jsonNode.toString(), new TypeReference<>() {});
        postRepository.saveAll(postList);
    }
}