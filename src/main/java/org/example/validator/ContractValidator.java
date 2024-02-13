package org.example.validator;

public class ContractValidator {
    private CustomersValidator customersValidator;
    private ServiceValidator serviceValidator;
    private TheDeadMenValidator theDeadMenValidator;

    public ContractValidator(CustomersValidator customersValidator, ServiceValidator serviceValidator,  TheDeadMenValidator theDeadMenValidator) {
        this.customersValidator = customersValidator;
        this.serviceValidator = serviceValidator;
        this.theDeadMenValidator = theDeadMenValidator;
    }

}