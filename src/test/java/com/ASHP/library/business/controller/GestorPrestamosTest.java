package com.ASHP.library.business.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import com.ASHP.library.business.TestRepoInitializer;
import com.ASHP.library.business.persistence.AutorDAO;
import com.ASHP.library.business.persistence.EjemplarDAO;
import com.ASHP.library.business.persistence.PrestamoDAO;
import com.ASHP.library.business.persistence.TituloDAO;
import com.ASHP.library.business.persistence.UsuarioDAO;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Calendar;
import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.CoreMatchers.not;

@AutoConfigureMockMvc
@SpringBootTest
@Transactional
public class GestorPrestamosTest {
    @Autowired
	private MockMvc mockMvc;

    @Autowired
    EjemplarDAO ejemplarDAO;
    @Autowired
    TituloDAO tituloDAO;
    @Autowired
    AutorDAO autorDAO;
    @Autowired
    UsuarioDAO usuarioDAO;
    @Autowired
    PrestamoDAO prestamoDAO;

    @BeforeEach
    void before() {
        TestRepoInitializer.initTitulos(ejemplarDAO, tituloDAO, autorDAO);
        TestRepoInitializer.initUsuarios(usuarioDAO);
    }

    @Test
	void GET_nuevoPrestamo_debe_mostrar_controles_para_elegir_titulo_y_usuario() throws Exception {
		this.mockMvc.perform(get("/nuevo-prestamo"))
            .andDo(print())
            .andExpect(status().isOk())
			.andExpect(content().string(containsString("Nuevo")))
            .andExpect(content().string(containsString("Título 1")))
            .andExpect(content().string(containsString("Título 2")))
            .andExpect(content().string(containsString("Usuario 1")))
            .andExpect(content().string(containsString("Usuario 2")));
	}

    @Test
	void POST_nuevoPrestamo_debe_mostrar_titulo_usuario_y_seleccion_ejemplares_disponibles() throws Exception {
        long idBorrado = TestRepoInitializer.ejemplares[1].getId();
        ejemplarDAO.delete(TestRepoInitializer.ejemplares[1]);

        this.mockMvc.perform(
            post("/nuevo-prestamo")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("usuario", TestRepoInitializer.usuarios[0].getId().toString())
                .param("titulo", TestRepoInitializer.titulos[0].getId().toString())
        ).andExpect(status().isOk())
         .andExpect(content().string(containsString("Usuario 1")))
         .andExpect(content().string(containsString("Título 1")))
         .andExpect(content().string(containsString("<option value=")))
         .andExpect(
            content().string(
                not(containsString("<option value=\"" + idBorrado + "\">"))));
    }

    @Test
	void POST_nuevoPrestamo_debe_mostrar_error_si_usuario_penalizado() throws Exception {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.DAY_OF_YEAR, 2);
        Date fechaPenalizado = calendar.getTime();

        TestRepoInitializer.usuarios[0].setFechaFinPenalizacion(fechaPenalizado);
        usuarioDAO.save(TestRepoInitializer.usuarios[0]);

        this.mockMvc.perform(
            post("/nuevo-prestamo")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("usuario", TestRepoInitializer.usuarios[0].getId().toString())
                .param("titulo", TestRepoInitializer.titulos[0].getId().toString())
        ).andExpect(status().isOk())
         .andExpect(content().string(containsString("Usuario penalizado")));
    }

    @Test
	void POST_nuevoPrestamo_crea_nuevo_prestamo_y_muestra_confirmacion() throws Exception {
        this.mockMvc.perform(
            post("/nuevo-prestamo")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("usuario", TestRepoInitializer.usuarios[0].getId().toString())
                .param("titulo", TestRepoInitializer.titulos[0].getId().toString())
                .param("ejemplar", TestRepoInitializer.ejemplares[0].getId().toString())
        ).andExpect(status().isOk())
         .andExpect(content().string(containsString("Préstamo creado correctamente")));
    }

    @Test
	void POST_nuevoPrestamo_error_si_ejemplar_no_disponible() throws Exception {
        TestRepoInitializer.initPrestamos(prestamoDAO);
        this.mockMvc.perform(
            post("/nuevo-prestamo")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("usuario", TestRepoInitializer.usuarios[0].getId().toString())
                .param("titulo", TestRepoInitializer.titulos[0].getId().toString())
                .param("ejemplar", TestRepoInitializer.ejemplares[2].getId().toString())
        ).andExpect(status().isOk())
         .andExpect(content().string(containsString("no se encuentra disponible")));
    }
}
