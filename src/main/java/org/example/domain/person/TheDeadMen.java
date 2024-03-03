package org.example.domain.person;

import java.time.LocalDate;

public class TheDeadMen extends Person{

    private LocalDate dateOfDead;

    public TheDeadMen(String surname, String name, String patronymic, LocalDate dateOfBirthday,  LocalDate dateOfDead) {
        super(surname, name, patronymic, dateOfBirthday);
        this.dateOfDead = dateOfDead;
    }

    public void setDateOfDead(LocalDate dateOfDead) {
        this.dateOfDead = dateOfDead;
    }

    public LocalDate getDateOfDead() {
        return dateOfDead;
    }
}
