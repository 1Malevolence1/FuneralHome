package org.example.validator;

import org.example.domain.email.Email;
import org.example.exception.VadilatorMenException;

import java.util.*;

public class EmailValidator {

    private Email email;

    public EmailValidator(Email email) {
        this.email = email;
    }


    private enum EmailExtension {
        ru, com
    }


    public boolean testEmail() throws VadilatorMenException {
        try {
            if (!email.getUsername().isEmpty() && !email.getDomain().isEmpty() && !email.getExtension().isEmpty()
                    && testDomainAndExtension(email.getDomain(), replaceExtension(email.getExtension()))) {

                return true;
            } else {
                throw new VadilatorMenException("ошибка данных почты");
            }
        } catch (VadilatorMenException e) {
            System.out.println(e.getErrorMessage());
        }
        return false;
    }

    private String replaceExtension(String string) {
        return string.replace(".", "");
    }


    private boolean testDomainAndExtension(String domain, String extension) {
        StringBuilder stringBuilder = new StringBuilder();

        ArrayList domains = completedDictionary().get(extension);

        for (int index = 0; index < domains.size(); index++) {
            if (domains.get(index).equals(domain)) return true;
        }

        return false;
    }

    private HashMap<String, ArrayList> completedDictionary() {
        HashMap<String, ArrayList> domain = new HashMap<>();

        ArrayList<String> domainRu = new ArrayList<>(List.of("@mail", "@yandex"));
        ArrayList<String> domainCom = new ArrayList<>(List.of("@gmail"));

        domain.put(EmailExtension.ru.name(), domainRu);
        domain.put(EmailExtension.com.name(), domainCom);

        return domain;
    }
}

