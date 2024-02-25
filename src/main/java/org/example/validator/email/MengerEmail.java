package org.example.validator.email;

import org.example.domain.email.Email;

public class MengerEmail {
    private Email email;

    public MengerEmail(Email email) {
        this.email = email;
    }

    public String fullEmail(){
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append(email.getUsername()).append(email.getDomain()).append(email.getExtension()).toString();
    }
}
