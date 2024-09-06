package com.project.userservice.model;

import lombok.Data;

@Data
public class FailureResponse implements Response {
    private final String message;
}