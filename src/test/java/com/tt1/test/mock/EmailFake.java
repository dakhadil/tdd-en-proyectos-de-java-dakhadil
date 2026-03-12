package com.tt1.test.mock;

import com.tt1.test.IEmail;
import java.util.ArrayList;

public class EmailFake implements IEmail {
    public ArrayList<String> enviados = new ArrayList<String>();

    @Override
    public boolean send(String email, String message) {
        enviados.add(email + "|" + message);
        return true;
    }
}