package com.example.oodbackend.exceptions;

public class SpringBootException extends RuntimeException  {
    public SpringBootException(String exMessage, Exception exception) {
        super(exMessage, exception);
    }

    public SpringBootException(String exMessage) {
        super(exMessage);
    }
}
