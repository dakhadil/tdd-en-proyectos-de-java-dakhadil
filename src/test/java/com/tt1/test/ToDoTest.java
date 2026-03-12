package com.tt1.test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ToDoTest {

    @Test
    void gettersAndSetters_work() {
        // Arrange
        ToDo t = new ToDo();
        t.setNombre("tarea1");
        t.setDescripcion("desc");
        t.setFechaLimite("2026-02-25");
        t.setCompletado(false);

        // Act + Assert
        assertEquals("tarea1", t.getNombre());
        assertEquals("desc", t.getDescripcion());
        assertEquals("2026-02-25", t.getFechaLimite());
        assertFalse(t.isCompletado());
    }
}