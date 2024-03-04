package com.example.systemproject.exceptions;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
@Getter
public class WrongStateException extends RuntimeException{
    @Value("${WrongStateException.message}")
    private String message;
}
