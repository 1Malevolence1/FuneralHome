package org.example.validator;

import org.example.answer.AnswerTheDeadMen;
import org.example.domain.contract.Contract;
import org.example.exception.VadilatorMenException;

public class ContractValidator {
    private CustomersValidator customersValidator;
    private ServiceValidator serviceValidator;
    private TheDeadMenValidator theDeadMenValidator;

    public ContractValidator( ) {
        this.customersValidator = new CustomersValidator();
        this.serviceValidator = new ServiceValidator();
        this.theDeadMenValidator = new TheDeadMenValidator();
    }

    private AnswerTheDeadMen checkTheDeadMen(Contract contract) throws VadilatorMenException {
            return theDeadMenValidator.check(contract);
    }

}