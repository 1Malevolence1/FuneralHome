package org.example.validator.person;

import org.example.answer.AnswerCustomers;
import org.example.domain.contract.Contract;
import org.example.exception.VadilatorMenException;
import org.example.validator.Validator;
import org.example.validator.email.EmailValidator;

public class CustomersValidator implements Validator {
    @Override
    public AnswerCustomers check(Contract contract) throws VadilatorMenException {
        FIOValidator fioValidator = new FIOValidator(contract.getCustomers());
        EmailValidator emailValidator = new EmailValidator(contract.getCustomers().getEmail());

        if(fioValidator.getFIOValidator() != null && emailValidator.testEmail()){
            AnswerCustomers answerAnswerCustomers = new AnswerCustomers();
           answerAnswerCustomers.setContract(contract);
            return answerAnswerCustomers;
        }
        else return null;
    }



}


