package org.example.validator.email;

import org.example.domain.email.Email;
import org.example.exception.VadilatorMenException;

import java.util.*;

public class EmailValidator {

    private Email email;

    public EmailValidator(Email email) {
        this.email = email;
    }

    // Добавлять новые расширения сюда, и вносить их в метод completedDictionary()
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

        HashMap<String, ArrayList<String>> dictionary = completedDictionary();

        ArrayList<String> domains = dictionary.get(extension);
        if (domains == null) {
            return false;
        }

        for (int index = 0; index < domains.size(); index++) {
            if (domains.get(index).equals(domain)) return true;
        }

        return false;
    }



    private HashMap<String, ArrayList<String>> completedDictionary() {
        HashMap<String, ArrayList<String>> domain = new HashMap<>();

        ArrayList<String> domainRu = new ArrayList<>(List.of("@mail", "@yandex"));
        ArrayList<String> domainCom = new ArrayList<>(List.of("@gmail"));

        domain.put(EmailExtension.ru.name(), domainRu);
        domain.put(EmailExtension.com.name(), domainCom);

        return domain;
    }
}

