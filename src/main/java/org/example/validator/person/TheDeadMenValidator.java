package org.example.validator.person;

import org.example.answer.AnswerTheDeadMen;
import org.example.domain.contract.Contract;
import org.example.domain.person.TheDeadMen;
import org.example.exception.VadilatorMenException;
import org.example.validator.Validator;

public class TheDeadMenValidator implements Validator {


    @Override
    public AnswerTheDeadMen check(Contract contract ) throws VadilatorMenException {

        FIOValidator fioValidator = new FIOValidator(contract.getTheDeadMen());

        if(fioValidator.getFIOValidator() != null ){
            AnswerTheDeadMen answerTheDeadMen = new AnswerTheDeadMen();
            answerTheDeadMen.setContractTheDeadMen(contract.getTheDeadMen());
            return answerTheDeadMen;
        }
        else return null;
    }

}

