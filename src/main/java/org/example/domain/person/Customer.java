package org.example.domain.person;

import org.example.domain.email.Email;

public class Customer extends Person {
    private Email email;

    public Customer(String surname, String name, String patronymic, String telephone, Email email) {
        super(surname, name, patronymic, telephone);
        this.email = email;

    }

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }
}
