package org.example.validator;

public class ContractValidator {
    private CustomersValidator customersValidator;
    private ServiceValidator serviceValidator;
    private StaffValidator staffValidator;
    private TheDeadMenValidator theDeadMenValidator;

    public ContractValidator(CustomersValidator customersValidator, ServiceValidator serviceValidator, StaffValidator staffValidator, TheDeadMenValidator theDeadMenValidator) {
        this.customersValidator = customersValidator;
        this.serviceValidator = serviceValidator;
        this.staffValidator = staffValidator;
        this.theDeadMenValidator = theDeadMenValidator;
    }


}
