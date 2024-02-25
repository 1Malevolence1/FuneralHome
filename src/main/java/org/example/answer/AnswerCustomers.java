package org.example.answer;

import org.example.domain.contract.Contract;
import org.example.domain.person.Customer;
import org.example.domain.person.TheDeadMen;

public class AnswerCustomers {
    private Customer contractCostumer;

    public void setContractTheDeadMen(Customer contractCostumer) {
        this.contractCostumer = contractCostumer;
    }

    public Customer getContractTheDeadMen() {
        return contractCostumer;
    }
}
