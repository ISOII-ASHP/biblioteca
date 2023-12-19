package com.ASHP.library.business.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.ui.Model;

import com.ASHP.library.business.entity.Ejemplar;
import com.ASHP.library.business.entity.Reserva;
import com.ASHP.library.business.entity.Titulo;
import com.ASHP.library.business.entity.Usuario;
import com.ASHP.library.business.persistence.EjemplarDAO;
import com.ASHP.library.business.persistence.ReservaDAO;
import com.ASHP.library.business.persistence.TituloDAO;
import com.ASHP.library.business.persistence.UsuarioDAO;

@RunWith(MockitoJUnitRunner.class)
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

    @InjectMocks
    private GestorPrestamos gestorPrestamos;

    private Titulo mockTitulo;
    private Usuario mockUsuario;
    private List<Ejemplar> mockEjemplares;

    @Before
    public void setup() {
        mockTitulo = new Titulo();
        mockUsuario = new Usuario();
        mockEjemplares = new ArrayList<>();
    }

    @Test
    public void reservarTitulo_NoEjemplaresDisponibles() {
        when(tituloDAO.findById(anyLong())).thenReturn(Optional.of(mockTitulo));
        when(usuarioDAO.findById(anyLong())).thenReturn(Optional.of(mockUsuario));
        when(mockTitulo.getEjemplares()).thenReturn(new ArrayList<>());

        String result = gestorPrestamos.reservarEjemplar(model, 1L, 1L);

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

        String result = gestorPrestamos.reservarEjemplar(model, 1L, 1L);

        verify(reservaDAO).save(any(Reserva.class));
        verify(ejemplarDAO).delete(any(Ejemplar.class));
        verify(model).addAttribute(eq("mensaje"), eq("Reserva realizada con éxito."));
        assertEquals("reservar-ejemplar", result);
    }
}