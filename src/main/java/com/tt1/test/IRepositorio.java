package com.tt1.test;

import java.util.ArrayList;
import java.util.Set;

public interface IRepositorio {
    void guardarToDo(ToDo todo);
    ToDo findToDo(String nombre); // null si no existe
    boolean marcarCompletado(String nombre);
    ArrayList<ToDo> getPendientes();

    void guardarEmail(String email);
    Set<String> getEmails(); // <-- Set para emails
}