package com.ASHP.library.business.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.ASHP.library.business.TestRepoInitializer;
import com.ASHP.library.business.entity.Usuario;
import com.ASHP.library.business.persistence.UsuarioDAO;

@AutoConfigureMockMvc
@SpringBootTest
@Transactional
public class GestorPenalizacionesTest {
    @Autowired
    UsuarioDAO usuarioDAO;
    @Autowired
    GestorPenalizaciones gestor;

    @BeforeEach
    void before() {
        TestRepoInitializer.initUsuarios(usuarioDAO);
    }

    @Test
    void aplicaPenalizacion_establece_una_fecha_de_penalizacion_mayor_a_hoy() {
        Usuario testUser = TestRepoInitializer.usuarios[0];
        testUser.setFechaFinPenalizacion(null);
        gestor.aplicarPenalizacion(testUser);
        Date ahora = new Date();
        Date penal = testUser.getFechaFinPenalizacion();
        assertNotNull(penal);
        assertEquals(true, ahora.compareTo(penal) < 0);
    }

    @Test
    void compruebaPenalizacion_devuelve_true_si_usuario_penalizado() {
        Usuario testUser = TestRepoInitializer.usuarios[0];
        testUser.setFechaFinPenalizacion(null);
        assertFalse(gestor.comprobarPenalizacion(testUser));

        gestor.aplicarPenalizacion(testUser);
        assertTrue(gestor.comprobarPenalizacion(testUser));
    }
    
}
