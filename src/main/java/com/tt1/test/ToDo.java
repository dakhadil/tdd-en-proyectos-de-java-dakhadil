package com.tt1.test;

public class ToDo {
    private String nombre;
    private String descripcion;
    private String fechaLimite; // YYYY-MM-DD
    private boolean completado;

    public ToDo() {
        // JavaBean: constructor vacío
        this.nombre = "";
        this.descripcion = "";
        this.fechaLimite = "";
        this.completado = false;
    }

    public ToDo(String nombre, String descripcion, String fechaLimite) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaLimite = fechaLimite;
        this.completado = false;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFechaLimite() {
        return fechaLimite;
    }

    public void setFechaLimite(String fechaLimite) {
        this.fechaLimite = fechaLimite;
    }

    public boolean isCompletado() {
        return completado;
    }

    public void setCompletado(boolean completado) {
        this.completado = completado;
    }
}