package org.example.validator;

import org.example.domain.contract.Contract;
import org.example.domain.person.Person;
import org.example.exception.TheDeadMenException;

public class FIOValidator {

    private Person person;

    public FIOValidator(Person person) {
        this.person = person;

    }

    public FIOValidator getFIOValidator() throws TheDeadMenException {
        FIOValidator fioValidator = new FIOValidator(person);

        try {

            if (checkName(person.getName()) &&
                    checkSurname(person.getSurname()) &&
                    checkPatronymic(person.getPatronymic())) {
                return fioValidator;
            }
        }catch (TheDeadMenException e) {
            System.out.println(e.getErrorMessage());
        }

        return null;
    }


    public boolean checkName(String name) throws TheDeadMenException {
        if (!name.matches(".*\\d.*")) return true;
        else throw new TheDeadMenException("Ошибка в именни");
    }


    public boolean checkSurname(String surname) throws TheDeadMenException {
        if (!surname.matches(".*\\d.*")) return true;
        else throw new TheDeadMenException("Ошибка в фамилии");
    }


    public boolean checkPatronymic(String patronymic) throws TheDeadMenException {
        if (!patronymic.matches(".*\\d.*")) return true;
        else throw new TheDeadMenException("Ошибка в отчестве");
    }
}
