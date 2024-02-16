package org.example.domain.email;

public class Email {
    private String username; // "kava1434"
    private String domain; // "mail"
    private String extension; // "ru"

    // Конструктор
    public Email(String username, String domain, String extension) {
        this.username = username;
        this.domain = domain;
        this.extension = extension;
    }

    public String getUsername() {
        return username;
    }

    public String getDomain() {
        return domain;
    }

    public String getExtension() {
        return extension;
    }
}
