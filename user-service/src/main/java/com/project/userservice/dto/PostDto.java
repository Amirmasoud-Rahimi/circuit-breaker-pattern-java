package com.project.userservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class PostDto {
    private int id;
    private int userId;
    private String title;
    private String body;
}