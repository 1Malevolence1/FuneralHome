package org.example.domain.person;

import java.time.LocalDate;

public class Staff extends Person {
    private String post;

    public Staff(String surname, String name, String patronymic, LocalDate dateOfBirthday, String telephone, String post) {
        super(surname, name, patronymic, dateOfBirthday, telephone);
        this.post = post;
        System.out.println();
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }
}
