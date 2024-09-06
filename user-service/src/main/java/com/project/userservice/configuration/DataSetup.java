package com.project.userservice.configuration;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.userservice.model.User;
import com.project.userservice.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Configuration
public class DataSetup {
    private final UserRepository userRepository;

    public DataSetup(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostConstruct
    public void setData() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonNode = mapper.readTree(new File("src/main/resources/users.json"));
        List<User> userList = mapper.readValue(jsonNode.toString(), new TypeReference<>() {});
        userRepository.saveAll(userList);
    }
}
