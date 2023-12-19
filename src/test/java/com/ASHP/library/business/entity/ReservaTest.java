package com.ASHP.library.business.entity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

class ReservaTest {

    @Test
    void testReserva() {
        Usuario usuario = new Usuario();
        Titulo titulo = new Titulo();
        Date fecha = new Date(System.currentTimeMillis());

        Reserva reserva = new Reserva((java.sql.Date) fecha, usuario, titulo);

        assertEquals(fecha, reserva.getFecha());
        assertEquals(usuario, reserva.getUsuario());
        assertEquals(titulo, reserva.getTitulo());
    }
}
