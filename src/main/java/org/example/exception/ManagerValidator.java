package org.example.exception;

public abstract class ManagerValidator extends Exception {
    private String errorMessage;

    public ManagerValidator(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage){
        this.errorMessage = errorMessage;
    }
}
