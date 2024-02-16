package org.example.exception;

public class VadilatorMenException extends Exception {
    private String errorMessage;

    public VadilatorMenException(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage){
        this.errorMessage = errorMessage;
    }
}

