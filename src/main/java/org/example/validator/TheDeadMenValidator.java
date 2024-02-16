package org.example.validator;

import org.example.answer.AnswerTheDeadMen;
import org.example.domain.contract.Contract;
import org.example.exception.VadilatorMenException;

public class TheDeadMenValidator implements  Validator {


    @Override
    public AnswerTheDeadMen check(Contract contract ) throws VadilatorMenException {

        FIOValidator fioValidator = new FIOValidator(contract.getTheDeadMen());

        if(fioValidator.getFIOValidator() != null ){
            AnswerTheDeadMen answerTheDeadMen = new AnswerTheDeadMen();
            answerTheDeadMen.setContract(contract);
            return answerTheDeadMen;
        }
        else return null;
    }


}
