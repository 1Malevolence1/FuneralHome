package org.example;

import org.example.domain.contract.Contract;
import org.example.domain.person.Customer;
import org.example.domain.person.Staff;
import org.example.domain.person.TheDeadMen;

import java.time.LocalDate;

public class TestBuilderContract {
    public static void main(String[] args) {

    }

    public Contract testBuild() {
        Contract contract = new Contract();

        Customer customer = new Customer(
                "Потапов",
                "Александр",
                "Арсентьевич",
                "+7 (977) 967-95-18",
                "Ромашка",
                "roupoucoffoiddou-9566@yopmail.com"

        );

        contract.setCustomers(customer);

        TheDeadMen theDeadMen = new TheDeadMen(
                "Рыбаков",
                "Богдан",
                "Макарович",
                LocalDate.of(12,11,1950),
                LocalDate.of(3,5,2022)
        );

        contract.setTheDeadMen(theDeadMen);


  /*      Staff staff = new Staff(
                "Хомяков",
                "Адам",
                "Эмильевич",
                LocalDate.of(16,12,1990),
                "+7 (988) 110-35-15",
                "Менеджер"
        );

        contract.setStaff(staff);
    }*/
        return contract;

    }
}
