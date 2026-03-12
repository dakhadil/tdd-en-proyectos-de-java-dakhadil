package com.tt1.test;

import java.util.ArrayList;
import java.util.Set;

public class Servicio {

    private IRepositorio repo;
    private IEmail emailer;

    public Servicio(IRepositorio repo, IEmail emailer) {
        this.repo = repo;
        this.emailer = emailer;
    }

    public void crearToDo(String nombre, String descripcion, String fechaLimite) {
        if (nombre == null || nombre.trim().isEmpty()) return;
        if (fechaLimite == null || fechaLimite.trim().isEmpty()) return;

        ToDo t = new ToDo(nombre, descripcion, fechaLimite);
        repo.guardarToDo(t);
    }

    public void agregarEmail(String email) {
        if (email == null || email.trim().isEmpty()) return;
        if (email.indexOf('@') < 0) return;

        repo.guardarEmail(email);
    }

    public boolean marcarFinalizada(String nombre) {
        return repo.marcarCompletado(nombre);
    }

    public ArrayList<ToDo> listarPendientes() {
        return repo.getPendientes();
    }

    // método para tests: evita depender de la fecha real del sistema
    public ArrayList<ToDo> listarPendientesConHoy(String hoyYYYYMMDD) {
        comprobarVencidasYAlertar(hoyYYYYMMDD);
        return repo.getPendientes();
    }

    private void comprobarVencidasYAlertar(String hoyYYYYMMDD) {
        ArrayList<ToDo> pendientes = repo.getPendientes();
        Set<String> emails = repo.getEmails(); // <-- Set

        for (ToDo t : pendientes) {
            String limite = t.getFechaLimite();
            if (limite != null && hoyYYYYMMDD != null) {
                if (limite.compareTo(hoyYYYYMMDD) < 0) {
                    String msg = "ALERTA: tarea vencida -> " + t.getNombre();
                    for (String e : emails) {
                        emailer.send(e, msg);
                    }
                }
            }
        }
    }
}