package com.tt1.test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RepositorioIntegrationTest {

    @Test
    void guardar_and_marcarCompletado_work_together() {
        DBStub db = new DBStub();
        IRepositorio repo = new Repositorio(db);

        ToDo t = new ToDo();
        t.setNombre("A");
        t.setDescripcion("x");
        t.setFechaLimite("2026-02-25");
        t.setCompletado(false);

        repo.guardarToDo(t);
        boolean ok = repo.marcarCompletado("A");
        ToDo encontrado = repo.findToDo("A");

        assertTrue(ok);
        assertNotNull(encontrado);
        assertTrue(encontrado.isCompletado());
    }
}