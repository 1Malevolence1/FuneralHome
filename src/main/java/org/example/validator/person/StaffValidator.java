package org.example.validator.person;

import org.example.domain.contract.Contract;
import org.example.domain.person.Staff;
import org.example.exception.VadilatorMenException;
import org.example.exception.ValidatorService;
import org.example.validator.Validator;

public class StaffValidator implements Validator<Staff, Staff>{
    @Override
    public Staff check(Staff staff)   {
        try {
            FIOValidator fioValidator = new FIOValidator(staff);

            if (fioValidator.getFIOValidator() != null
                    && !staff.getPost().isEmpty() && !staff.getPost().isEmpty() && !staff.getPost().isEmpty()){
                 return staff;
            } else {
                throw new ValidatorService("Ошибка в данных работника");
            }
        } catch (ValidatorService | VadilatorMenException e) {
            System.out.println(e.getErrorMessage());
        }
        return null;
    }
    }

