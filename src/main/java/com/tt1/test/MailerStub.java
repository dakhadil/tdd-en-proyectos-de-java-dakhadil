package com.tt1.test;

public class MailerStub implements IEmail {

    @Override
    public boolean send(String email, String message) {
        throw new UnsupportedOperationException("Clase aún no implementada.");
    }
}