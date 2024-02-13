package org.example.domen.person;

import java.time.LocalDate;

public abstract class Person {
    private String surname;
    private String name;
    private String patronymic;

    private LocalDate dateOfBirthday;

    private String telephone;

    // конструктоор для TheDeadMen
    public Person(String surname, String name, String patronymic, LocalDate dateOfBirthday) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.dateOfBirthday = dateOfBirthday;
    }

    // конструктор для Staff
    public Person(String surname, String name, String patronymic, LocalDate dateOfBirthday, String telephone) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.dateOfBirthday = dateOfBirthday;
        this.telephone = telephone;
    }

    // конструктор для Customers
    public Person(String surname, String name, String patronymic, String telephone) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.telephone = telephone;
    }

    public Person() {
    }


    public LocalDate getDateOfBirthday() {
        return dateOfBirthday;
    }

    public void setDateOfBirthday(LocalDate dateOfBirthday) {
        this.dateOfBirthday = dateOfBirthday;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }
}
