package com.tt1.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class DBStub {

    private HashMap<String, ToDo> todos;   // clave = nombre
    private Set<String> emails;            // evita duplicados

    public DBStub() {
        this.todos = new HashMap<>();
        this.emails = new HashSet<>();
    }

    // CRUD ToDos
    public void create(ToDo todo) {
        if (todo == null || todo.getNombre() == null) return;
        todos.put(todo.getNombre(), todo);
    }

    public ArrayList<ToDo> readAll() {
        return new ArrayList<>(todos.values());
    }

    public ToDo findByName(String nombre) {
        return todos.get(nombre);
    }

    public boolean update(ToDo todo) {
        if (todo == null || todo.getNombre() == null) return false;
        if (!todos.containsKey(todo.getNombre())) return false;
        todos.put(todo.getNombre(), todo);
        return true;
    }

    public boolean deleteByName(String nombre) {
        return todos.remove(nombre) != null;
    }

    // Emails
    public void addEmail(String email) {
        if (email == null) return;
        emails.add(email);
    }

    public Set<String> getEmails() {
        return emails;
    }
}