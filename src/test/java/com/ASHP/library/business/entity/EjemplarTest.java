package com.ASHP.library.business.entity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EjemplarTest {

    @Test
    void testEjemplar() {
        Titulo titulo = new Titulo();

        Ejemplar ejemplar = new Ejemplar(titulo);

        assertEquals(titulo, ejemplar.getTitulo());
    }
}
