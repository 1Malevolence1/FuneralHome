package org.example.domain.person;

public class Customer extends Person {
    private String address;
    private String email;

    public Customer(String surname, String name, String patronymic, String telephone, String address, String email) {
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
