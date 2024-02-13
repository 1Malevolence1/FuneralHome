package org.example.domen.person;

import jdk.vm.ci.meta.Local;

import java.time.LocalDate;

public class TheDeadMen extends Person{

    private LocalDate dateOfDead;

    public TheDeadMen(String surname, String name, String patronymic, LocalDate dateOfDead) {
        super(surname, name, patronymic);
        this.dateOfDead = dateOfDead;
    }

    public TheDeadMen() {
    }

    public void setDateOfDead(LocalDate dateOfDead) {
        this.dateOfDead = dateOfDead;
    }

    public LocalDate getDateOfDead() {
        return dateOfDead;
    }
}
