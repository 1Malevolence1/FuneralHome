package org.example.domen.person;

public class Customers extends Person {
    private String address;
    private String email;

    public Customers(String surname, String name, String patronymic, String telephone, String address, String email) {
        super(surname, name, patronymic, telephone);
        this.address = address;
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
