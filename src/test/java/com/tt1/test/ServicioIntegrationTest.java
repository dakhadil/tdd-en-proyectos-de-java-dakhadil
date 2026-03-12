package com.tt1.test;

import com.tt1.test.mock.EmailFake;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ServicioIntegrationTest {

    @Test
    void alert_is_sent_when_there_are_overdue_todos() {
        DBStub db = new DBStub();
        IRepositorio repo = new Repositorio(db);
        EmailFake email = new EmailFake();
        Servicio servicio = new Servicio(repo, email);

        servicio.agregarEmail("x@x.com");
        servicio.crearToDo("A", "desc", "2026-02-01"); // vencida

        servicio.listarPendientesConHoy("2026-02-25");

        assertEquals(1, email.enviados.size());
        assertTrue(email.enviados.get(0).contains("x@x.com"));
        assertTrue(email.enviados.get(0).contains("ALERTA"));
    }
}