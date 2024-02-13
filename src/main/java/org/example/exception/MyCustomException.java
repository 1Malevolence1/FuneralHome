package org.example.exception;

public class MyCustomException {
    private String errorMessage;

    public MyCustomException(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}

