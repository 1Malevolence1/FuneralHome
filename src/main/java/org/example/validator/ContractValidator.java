package org.example.validator;

import org.example.answer.AnswerCustomers;
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

    public Contract checkAll(Contract contract) throws VadilatorMenException {

        try {

            AnswerTheDeadMen answerTheDeadMen = checkTheDeadMen(contract);
            AnswerCustomers answerCustomers = checkCustomers(contract);

            if(answerCustomers != null && answerTheDeadMen != null){
                return contract;
            }
            else throw  new VadilatorMenException("Ошибка в контракте");
        } catch (VadilatorMenException e){
            System.out.println(e.getErrorMessage());
        }
        return null;
    }

    private AnswerTheDeadMen checkTheDeadMen(Contract contract) throws VadilatorMenException {
            return theDeadMenValidator.check(contract);
    }

    private AnswerCustomers checkCustomers(Contract contract) throws VadilatorMenException{
        return customersValidator.check(contract);
    }

}