package com.example.restapi.execption_handling;

public class NoSuchEmployeeException  extends RuntimeException{
    public NoSuchEmployeeException(String message) {
        super(message);
    }
}
