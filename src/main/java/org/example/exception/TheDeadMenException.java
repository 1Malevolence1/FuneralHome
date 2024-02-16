package org.example.exception;

import java.awt.*;

public class TheDeadMenException extends Exception {
    private String errorMessage;

    public TheDeadMenException(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage){
        this.errorMessage = errorMessage;
    }
}

