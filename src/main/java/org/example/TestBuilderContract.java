package org.example;

import org.example.domain.contract.Contract;
import org.example.domain.person.Customer;
import org.example.domain.person.Staff;
import org.example.domain.person.TheDeadMen;

import java.time.LocalDate;

public class TestBuilderContract {
    public static void main(String[] args) {

    }

    public Contract testBuildGood() {
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
                LocalDate.of(1950,11,12),
                LocalDate.of(2022,5,12)
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


    public Contract testBuildBad() {
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
                LocalDate.of(1950,11,12),
                LocalDate.of(2022,5,12)
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
