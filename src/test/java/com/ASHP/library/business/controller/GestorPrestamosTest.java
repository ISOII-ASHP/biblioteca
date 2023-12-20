package com.ASHP.library.business.controller;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.ASHP.library.business.TestRepoInitializer;
import com.ASHP.library.business.entity.Ejemplar;
import com.ASHP.library.business.entity.Reserva;
import com.ASHP.library.business.entity.Titulo;
import com.ASHP.library.business.entity.Usuario;
import com.ASHP.library.business.persistence.AutorDAO;
import com.ASHP.library.business.persistence.EjemplarDAO;
import com.ASHP.library.business.persistence.PrestamoDAO;
import com.ASHP.library.business.persistence.ReservaDAO;
import com.ASHP.library.business.persistence.TituloDAO;
import com.ASHP.library.business.persistence.UsuarioDAO;

@AutoConfigureMockMvc
@SpringBootTest
@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
public class GestorPrestamosTest {

    @Mock
    private TituloDAO tituloDAO;
    @Mock
    private UsuarioDAO usuarioDAO;
    @Mock
    private EjemplarDAO ejemplarDAO;
    @Mock
    private ReservaDAO reservaDAO;
    @Mock
    private Model model;
    
    @Autowired
	private MockMvc mockMvc;

    @Autowired
    EjemplarDAO ejemplarrDAO;
    @Autowired
    TituloDAO titulooDAO;
    @Autowired
    AutorDAO autorDAO;
    @Autowired
    UsuarioDAO usuariooDAO;
    @Autowired
    PrestamoDAO prestamoDAO;

    @InjectMocks
    private GestorPrestamos gestorPrestamos;

    private Titulo mockTitulo;
    private Usuario mockUsuario;
    private List<Ejemplar> mockEjemplares;

    @BeforeEach
    public void setup() {
        mockTitulo = new Titulo();
        mockUsuario = new Usuario();
        mockEjemplares = new ArrayList<>();
        TestRepoInitializer.initTitulos(ejemplarrDAO, titulooDAO, autorDAO);
        TestRepoInitializer.initUsuarios(usuariooDAO);
    }

    @Test
    public void reservarTitulo_NoEjemplaresDisponibles() {
        when(tituloDAO.findById(anyLong())).thenReturn(Optional.of(mockTitulo));
        when(usuarioDAO.findById(anyLong())).thenReturn(Optional.of(mockUsuario));
        when(mockTitulo.getEjemplares()).thenReturn(new ArrayList<>());

        String result = gestorPrestamos.reservaEjemplar(model, 1L, 1L);

        verify(model).addAttribute(eq("mensaje"), eq("No hay ejemplares disponibles de este título."));
        assertEquals("reservar-ejemplar", result);
    }

    @Test
    public void reservarTitulo_ConEjemplaresDisponibles() {
        Ejemplar mockEjemplar = new Ejemplar();
        mockEjemplares.add(mockEjemplar);

        when(tituloDAO.findById(anyLong())).thenReturn(Optional.of(mockTitulo));
        when(usuarioDAO.findById(anyLong())).thenReturn(Optional.of(mockUsuario));
        when(mockTitulo.getEjemplares()).thenReturn(mockEjemplares);
        when(mockEjemplares.get(0)).thenReturn(mockEjemplar);

        String result = gestorPrestamos.reservaEjemplar(model, 1L, 1L);

        verify(reservaDAO).save(any(Reserva.class));
        verify(ejemplarDAO).delete(any(Ejemplar.class));
        verify(model).addAttribute(eq("mensaje"), eq("Reserva realizada con éxito."));
        assertEquals("reservar-ejemplar", result);
    }
    

    @Test
	public void GET_nuevoPrestamo_debe_mostrar_controles_para_elegir_titulo_y_usuario() throws Exception {
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
	public void POST_nuevoPrestamo_debe_mostrar_titulo_usuario_y_seleccion_ejemplares_disponibles() throws Exception {
        long idBorrado = TestRepoInitializer.ejemplares[1].getId();
        ejemplarrDAO.delete(TestRepoInitializer.ejemplares[1]);

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
	public void POST_nuevoPrestamo_debe_mostrar_error_si_usuario_penalizado() throws Exception {
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
	public void POST_nuevoPrestamo_crea_nuevo_prestamo_y_muestra_confirmacion() throws Exception {
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
	public void POST_nuevoPrestamo_error_si_ejemplar_no_disponible() throws Exception {
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