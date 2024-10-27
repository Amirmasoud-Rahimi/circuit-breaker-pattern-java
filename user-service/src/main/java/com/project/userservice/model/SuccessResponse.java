package com.project.userservice.model;

import lombok.*;

@Data
public class SuccessResponse implements Response {
    private String name;
    private String username;
    private String email;
    private String phone;
    private String website;
    private String postTitle;
    private String postBody;
}