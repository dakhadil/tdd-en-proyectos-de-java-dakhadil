package com.tt1.test;

import java.util.ArrayList;
import java.util.Set;

public class Repositorio implements IRepositorio {

    private DBStub db;

    public Repositorio(DBStub db) {
        this.db = db;
    }

    @Override
    public void guardarToDo(ToDo todo) {
        db.create(todo);
    }

    @Override
    public ToDo findToDo(String nombre) {
        return db.findByName(nombre);
    }

    @Override
    public boolean marcarCompletado(String nombre) {
        ToDo t = db.findByName(nombre);
        if (t == null) return false;
        t.setCompletado(true);
        return db.update(t);
    }

    @Override
    public ArrayList<ToDo> getPendientes() {
        ArrayList<ToDo> res = new ArrayList<>();
        for (ToDo t : db.readAll()) {
            if (!t.isCompletado()) res.add(t);
        }
        return res;
    }

    @Override
    public void guardarEmail(String email) {
        db.addEmail(email);
    }

    @Override
    public Set<String> getEmails() {
        return db.getEmails();
    }
}