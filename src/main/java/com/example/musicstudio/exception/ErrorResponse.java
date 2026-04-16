package com.example.musicstudio.exception;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class ErrorResponse {
    String message;
    int statusCode;
    LocalDateTime timestamp;
}
