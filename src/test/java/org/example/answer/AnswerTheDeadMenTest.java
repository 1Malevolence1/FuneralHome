package org.example.answer;

import org.example.TestBuilderContract;
import org.example.exception.TheDeadMenException;
import org.example.validator.TheDeadMenValidator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnswerTheDeadMenTest {

    @Test
    public void testFIO() throws TheDeadMenException {
        TestBuilderContract testContract = new TestBuilderContract();


        TheDeadMenValidator theDeadMenValidator = new TheDeadMenValidator();

        assertNotNull(theDeadMenValidator.check(testContract.testBuildBad()));

    }
}