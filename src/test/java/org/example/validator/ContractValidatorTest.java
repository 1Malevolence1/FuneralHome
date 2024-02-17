package org.example.validator;

import org.example.domain.contract.Contract;
import org.example.domain.email.Email;
import org.example.domain.person.Customer;
import org.example.domain.person.TheDeadMen;
import org.example.exception.VadilatorMenException;
import org.example.validator.contract.ContractValidator;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ContractValidatorTest {

    @Test
    public void test1() throws VadilatorMenException {


        Contract contract = new Contract();
        ContractValidator contractValidator = new ContractValidator();
        Customer customer = new Customer(
                "Потапов",
                "Александр",
                "Арсентьевич",
                "+7 (977) 967-95-18",
                new Email("roupoucoffoiddou", "@mail", ".ru")
        );

        contract.setCustomers(customer);

        TheDeadMen theDeadMen = new TheDeadMen(
                "Рыбаков",
                "Богдан",
                "Макарович",
                LocalDate.of(1950,11,12),
                LocalDate.of(2022,5,12)
        );

        contract.setTheDeadMen(theDeadMen);

        assertNotNull(contractValidator.checkAll(contract));
    }



    @Test
    public void test2() throws VadilatorMenException {
        ContractValidator contractValidator = new ContractValidator();
        Contract contract = new Contract();
        Customer customer = new Customer(
                "Потапов12",
                "Александр",
                "Арсентьевич",
                "+7 (977) 967-95-18",
                new Email("roupoucoffoiddou", "@mail", ".ru")
        );

        contract.setCustomers(customer);

        TheDeadMen theDeadMen = new TheDeadMen(
                "Рыбаков",
                "Богдан",
                "Макарович",
                LocalDate.of(1950,11,12),
                LocalDate.of(2022,5,12)
        );

        contract.setTheDeadMen(theDeadMen);

        assertNotNull(contractValidator.checkAll(contract));
    }



    @Test
    public void test3() throws VadilatorMenException {
        ContractValidator contractValidator = new ContractValidator();
        Contract contract = new Contract();
        Customer customer = new Customer(
                "Потапов!",
                "Александр",
                "Арсентьевич",
                "+7 (977) 967-95-18",
                new Email("roupoucoffoiddou", "@mail", ".ru")
        );

        contract.setCustomers(customer);

        TheDeadMen theDeadMen = new TheDeadMen(
                "Рыбаков",
                "Богдан",
                "Макарович123",
                LocalDate.of(1950,11,12),
                LocalDate.of(2022,5,12)
        );

        contract.setTheDeadMen(theDeadMen);

        assertNotNull(contractValidator.checkAll(contract));
    }


    @Test
    public void test4() throws VadilatorMenException {
        ContractValidator contractValidator = new ContractValidator();
        Contract contract = new Contract();
        Customer customer = new Customer(
                "Потапов",
                "Александр",
                "Арсентьевич",
                "+7 (977) 967-95-18",
                new Email("roupoucoffoiddou", "", ".ru")
        );

        contract.setCustomers(customer);

        TheDeadMen theDeadMen = new TheDeadMen(
                "Рыбаков",
                "Богдан",
                "Макарович",
                LocalDate.of(1950,11,12),
                LocalDate.of(2022,5,12)
        );

        contract.setTheDeadMen(theDeadMen);

        assertNotNull(contractValidator.checkAll(contract));
    }


    @Test
    public void test5() throws VadilatorMenException {
        ContractValidator contractValidator = new ContractValidator();
        Contract contract = new Contract();
        Customer customer = new Customer(
                "Потапов",
                "Александр",
                "Арсентьевич",
                "+7 (977) 967-95-18",
                new Email("roupoucoffoiddou", "@mail", ".r")
        );

        contract.setCustomers(customer);

        TheDeadMen theDeadMen = new TheDeadMen(
                "Рыбаков",
                "Богдан",
                "Макарович",
                LocalDate.of(1950,11,12),
                LocalDate.of(2022,5,12)
        );

        contract.setTheDeadMen(theDeadMen);

        assertNotNull(contractValidator.checkAll(contract));
    }

}


