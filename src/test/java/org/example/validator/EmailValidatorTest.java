package org.example.validator;

import org.example.domain.email.Email;
import org.example.exception.VadilatorMenException;
import org.example.validator.email.EmailValidator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmailValidatorTest {


    @Test
    public void test1() throws VadilatorMenException {
        Email email = new Email("", "@mail", ".ru");
        EmailValidator emailValidator = new EmailValidator(email);
        assertFalse(emailValidator.testEmail());
    }

    @Test
    public void test2()throws VadilatorMenException{
        Email email = new Email("roupoucoffoiddou", "", ".ru");
        EmailValidator emailValidator = new EmailValidator(email);
        assertFalse(emailValidator.testEmail());
    }

    @Test
    public void test3()throws VadilatorMenException{
        Email email = new Email("roupoucoffoiddou", "@mail", "");
        EmailValidator emailValidator = new EmailValidator(email);
        assertFalse(emailValidator.testEmail());
    }

    @Test
    public void test4()throws VadilatorMenException{
        Email email = new Email("roupoucoffoiddou", "@m", ".ru");
        EmailValidator emailValidator = new EmailValidator(email);
        assertFalse(emailValidator.testEmail());
    }
    @Test
    public void test5()throws VadilatorMenException{
        Email email = new Email("roupoucoffoiddou", "@gmail", ".ru");
        EmailValidator emailValidator = new EmailValidator(email);
        assertFalse(emailValidator.testEmail());
    }

    @Test
    public void test6()throws VadilatorMenException{
        Email email = new Email("roupoucoffoiddou", "@gmail", ".com");
        EmailValidator emailValidator = new EmailValidator(email);
        assertTrue(emailValidator.testEmail());
    }

}