package org.example.validator.email;

import org.example.domain.email.Email;

public class MengerEmail {
    private Email email;

    public MengerEmail(Email email) {
        this.email = email;
    }

    public MengerEmail(){

    }
    public String fullEmail(){
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append(email.getUsername()).append(email.getDomain()).append(email.getExtension()).toString();
    }
    public Email splitEmail(String fullEmail){
        StringBuilder stringBuilder = new StringBuilder(fullEmail);

        int itemOne = stringBuilder.indexOf("@");
        int itemTwo = stringBuilder.indexOf(".");

        String userName = stringBuilder.substring(0, itemOne);
        String domain = stringBuilder.substring(itemOne, itemTwo);
        String extension = stringBuilder.substring(itemTwo, stringBuilder.length());

        return new Email(userName, domain, extension);
    }
}
