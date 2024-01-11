package com.mehdi.socialmedia.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorDetais {
    private String message;
    private String error;
    private LocalDateTime timestamp;



}
