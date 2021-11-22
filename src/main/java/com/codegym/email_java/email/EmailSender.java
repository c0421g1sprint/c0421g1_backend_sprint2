package com.codegym.email_java.email;

public interface EmailSender {
    void send(String to, String email);

    String buildRegisterEmail(String link);

    String buildForgetPassEmail(String randomPass);
}