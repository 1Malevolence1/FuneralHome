package org.example.validator.person;

import org.example.domain.person.Person;
import org.example.exception.VadilatorMenException;

public class FIOValidator {

    private Person person;

    public FIOValidator(Person person) {
        this.person = person;

    }

    public FIOValidator getFIOValidator() throws VadilatorMenException {
        FIOValidator fioValidator = new FIOValidator(person);

        try {

            if (checkName(person.getName()) &&
                    checkSurname(person.getSurname()) &&
                    checkPatronymic(person.getPatronymic())) {
                return fioValidator;
            }
        }catch (VadilatorMenException e) {
            System.out.println(e.getErrorMessage());
        }

        return null;
    }


    public boolean checkName(String name) throws VadilatorMenException {
        if (!name.matches(".*\\d.*")) return true;
        else throw new VadilatorMenException("Ошибка в именни");
    }


    public boolean checkSurname(String surname) throws VadilatorMenException {
        if (!surname.matches(".*\\d.*")) return true;
        else throw new VadilatorMenException("Ошибка в фамилии");
    }


    public boolean checkPatronymic(String patronymic) throws VadilatorMenException {
        if (!patronymic.matches(".*\\d.*")) return true;
        else throw new VadilatorMenException("Ошибка в отчестве");
    }
}
