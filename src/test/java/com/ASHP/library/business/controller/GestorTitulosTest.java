package com.ASHP.library.business.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.ui.Model;
import static org.mockito.Mockito.*;
import static org.junit.Assert.assertEquals;

import com.ASHP.library.business.entity.Autor;
import com.ASHP.library.business.entity.Ejemplar;
import com.ASHP.library.business.entity.Titulo;
import com.ASHP.library.business.persistence.AutorDAO;
import com.ASHP.library.business.persistence.EjemplarDAO;
import com.ASHP.library.business.persistence.TituloDAO;

@RunWith(MockitoJUnitRunner.class)
public class GestorTitulosTest {
	@Mock
	private AutorDAO autorDAO;

	@Mock
	private EjemplarDAO ejemplarDAO;

	@Mock
	private TituloDAO tituloDAO;

    @Mock
    private Model model;

    @InjectMocks
    private GestorTitulos gestorTitulos;

    @BeforeClass
    public void setUpBeforeClass() throws Exception {
    }

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}


	@Test
	public void testAltaTitulo() {
	    List<String> tituloInfo = Arrays.asList("Nombre del Título", "ISBN123", "NR123");
	    List<String> autorInfo = Arrays.asList("Nombre del Autor", "Apellido del Autor");
	    Model mockModel = mock(Model.class);

	    when(tituloDAO.save(any(Titulo.class))).thenReturn(new Titulo());
	    when(autorDAO.save(any(Autor.class))).thenReturn(new Autor());
	    when(ejemplarDAO.save(any(Ejemplar.class))).thenReturn(new Ejemplar());

	    String viewName = gestorTitulos.altaTitulo(tituloInfo, autorInfo, mockModel);

	    verify(tituloDAO).save(any(Titulo.class));
	    verify(autorDAO).save(any(Autor.class));
	    verify(ejemplarDAO).save(any(Ejemplar.class));
	    assertEquals("redirect:/vista-titulo", viewName);
	}

	@Test
	public void testAltaEjemplar() {
	    Long tituloId = 1L;
	    int numEjemplares = 3;

	    // Creamos un objeto Titulo para utilizarlo en la creación del Ejemplar
	    Titulo mockTitulo = new Titulo();
	    mockTitulo.setTitulo("Título");
	    mockTitulo.setId(tituloId);
	    mockTitulo.setIsbn("ISBN123");

	    // Creamos un Ejemplar utilizando el mockTitulo
	    Ejemplar mockEjemplar = new Ejemplar(mockTitulo);

	    when(tituloDAO.findById(anyLong())).thenReturn(Optional.of(mockTitulo));
	    when(ejemplarDAO.findById(anyLong())).thenReturn(Optional.of(mockEjemplar));
	    when(ejemplarDAO.save(any(Ejemplar.class))).thenReturn(new Ejemplar());

	    String viewName = gestorTitulos.altaEjemplar(mockEjemplar, tituloId, numEjemplares);

	    verify(tituloDAO).findById(anyLong());
	    verify(ejemplarDAO, times(numEjemplares - 1)).save(any(Ejemplar.class));

	    assertEquals("vista-titulo", viewName);
	}

}
