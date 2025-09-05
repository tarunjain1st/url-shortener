package com.example.backendservice.exceptions;

public class InvalidUrlException extends Exception{
    public InvalidUrlException(String message){
        super(message);
    }
}
