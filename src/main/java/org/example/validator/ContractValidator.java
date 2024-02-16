package org.example.validator;

import org.example.answer.AnswerCustomers;
import org.example.answer.AnswerTheDeadMen;
import org.example.domain.contract.Contract;
import org.example.exception.TheDeadMenException;

public class ContractValidator {
    private CustomersValidator customersValidator;
    private ServiceValidator serviceValidator;
    private TheDeadMenValidator theDeadMenValidator;

    public ContractValidator( ) {
        this.customersValidator = new CustomersValidator();
        this.serviceValidator = new ServiceValidator();
        this.theDeadMenValidator = new TheDeadMenValidator();
    }

    private AnswerTheDeadMen checkTheDeadMen(Contract contract) throws TheDeadMenException {
            return theDeadMenValidator.check(contract);
    }

}