package org.example.answer;

import org.example.TestBuilderContract;
import org.example.domain.contract.Contract;
import org.example.exception.VadilatorMenException;
import org.example.validator.contract.ContractValidator;

public class AnswerContract {

//    @TODO должнен будет получать объект откуда будут приходить данные
    public Contract getContract(Contract contract) throws VadilatorMenException {
        ContractValidator contractValidator = new ContractValidator();
        return contractValidator.checkAll(contract);

    }
}

