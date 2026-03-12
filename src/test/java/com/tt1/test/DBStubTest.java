package com.tt1.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DBStubTest {

    private DBStub db;

    @BeforeEach
    void setUp() {
        db = new DBStub();
    }

    @Test
    void create_and_findByName() {
        ToDo t = new ToDo();
        t.setNombre("A");
        t.setDescripcion("x");
        t.setFechaLimite("2026-02-25");
        t.setCompletado(false);

        db.create(t);
        ToDo encontrado = db.findByName("A");

        assertNotNull(encontrado);
        assertEquals("A", encontrado.getNombre());
    }

    @Test
    void update_changes_existing() {
        ToDo t = new ToDo();
        t.setNombre("A");
        t.setDescripcion("x");
        t.setFechaLimite("2026-02-25");
        t.setCompletado(false);
        db.create(t);

        ToDo t2 = new ToDo();
        t2.setNombre("A");
        t2.setDescripcion("nuevo");
        t2.setFechaLimite("2026-02-26");
        t2.setCompletado(true);

        boolean ok = db.update(t2);
        ToDo encontrado = db.findByName("A");

        assertTrue(ok);
        assertEquals("nuevo", encontrado.getDescripcion());
        assertTrue(encontrado.isCompletado());
    }

    @Test
    void delete_removes_existing() {
        ToDo t = new ToDo();
        t.setNombre("A");
        t.setDescripcion("x");
        t.setFechaLimite("2026-02-25");
        t.setCompletado(false);
        db.create(t);

        boolean ok = db.deleteByName("A");

        assertTrue(ok);
        assertNull(db.findByName("A"));
    }

    @Test
    void addEmail_and_getEmails() {
        db.addEmail("a@a.com");
        db.addEmail("b@b.com");

        assertEquals(2, db.getEmails().size());
        assertTrue(db.getEmails().contains("a@a.com"));
        assertTrue(db.getEmails().contains("b@b.com"));
    }
}