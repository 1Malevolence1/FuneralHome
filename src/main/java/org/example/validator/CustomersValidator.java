package org.example.validator;

import org.example.answer.AnswerTheDeadMen;
import org.example.domain.contract.Contract;
import org.example.exception.VadilatorMenException;

public class CustomersValidator implements Validator {
    @Override
    public Object check(Contract contract) throws VadilatorMenException {
        FIOValidator fioValidator = new FIOValidator(contract.getTheDeadMen());
        EmailValidator emailValidator = new EmailValidator(contract.getCustomers().getEmail());

        if(fioValidator.getFIOValidator() != null && emailValidator.testEmail()){
            AnswerTheDeadMen answerTheDeadMen = new AnswerTheDeadMen();
            answerTheDeadMen.setContract(contract);
            return answerTheDeadMen;
        }
        else return null;
    }



}


