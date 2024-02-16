package org.example.answer;

import org.example.TestBuilderContract;
import org.example.domain.contract.Contract;
import org.example.domain.person.TheDeadMen;
import org.example.exception.VadilatorMenException;
import org.example.validator.TheDeadMenValidator;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class AnswerTheDeadMenTest {

    @Test
    public void test1() throws VadilatorMenException {
        Contract contract = new Contract();
        TheDeadMen theDeadMen = new TheDeadMen(
                "Рыбаков.",
                "Богдан",
                "Макарович",
                LocalDate.of(1950, 11, 12),
                LocalDate.of(2022, 5, 12)
        );
        contract.setTheDeadMen(theDeadMen);
        TheDeadMenValidator theDeadMenValidator = new TheDeadMenValidator();
        assertNotNull(theDeadMenValidator.checkTheDedMen(contract));

    }

    @Test
    public void test2() throws VadilatorMenException {
        Contract contract = new Contract();
        TheDeadMen theDeadMen = new TheDeadMen(
                "Рыбаков",
                "Богдан!",
                "Макарович",
                LocalDate.of(1950, 11, 12),
                LocalDate.of(2022, 5, 12)
        );
        contract.setTheDeadMen(theDeadMen);
        TheDeadMenValidator theDeadMenValidator = new TheDeadMenValidator();
        assertNotNull(theDeadMenValidator.checkTheDedMen(contract));

    }

    @Test
    public void test3() throws VadilatorMenException {
        Contract contract = new Contract();
        TheDeadMen theDeadMen = new TheDeadMen(
                "Рыбаков",
                "Богдан",
                "Макарович@",
                LocalDate.of(1950, 11, 12),
                LocalDate.of(2022, 5, 12)
        );
        contract.setTheDeadMen(theDeadMen);
        TheDeadMenValidator theDeadMenValidator = new TheDeadMenValidator();
        assertNotNull(theDeadMenValidator.checkTheDedMen(contract));

    }
    @Test
    public void test4() throws VadilatorMenException {
        Contract contract = new Contract();
        TheDeadMen theDeadMen = new TheDeadMen(
                "Рыбаков",
                "Богдан.",
                "Макарович",
                LocalDate.of(1950, 11, 12),
                LocalDate.of(2022, 5, 12)
        );
        contract.setTheDeadMen(theDeadMen);
        TheDeadMenValidator theDeadMenValidator = new TheDeadMenValidator();
        assertNotNull(theDeadMenValidator.checkTheDedMen(contract));

    }
}
