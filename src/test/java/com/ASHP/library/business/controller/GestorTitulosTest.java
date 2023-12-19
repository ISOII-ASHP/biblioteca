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
import static org.junit.Assert.assertTrue;

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
	
	@Test
    public void testVerListaLibros() {
        Titulo titulo1 = new Titulo();
        Titulo titulo2 = new Titulo();
        when(tituloDAO.findAll()).thenReturn(Arrays.asList(titulo1, titulo2));

        String view = gestorTitulos.verListaLibros(model);

        verify(model, times(1)).addAttribute("listaLibros", Arrays.asList(titulo1, titulo2));
        assertEquals("vista-titulo", view);
    }
	
	@Test
	public void testLlevaraactualizarTitulo() {
	    Long tituloId = 1L;
	    Titulo titulo = new Titulo();
	    when(tituloDAO.findById(tituloId)).thenReturn(Optional.of(titulo));

	    String view = gestorTitulos.llevaraactualizarTitulo(tituloId, model);

	    verify(model, times(1)).addAttribute("titulo", titulo);
	    assertEquals("modificar-titulo", view);
	}

	@Test
	public void testActualizarTitulo() {
	    Long tituloId = 1L;
	    Titulo tituloActualizado = new Titulo();
	    tituloActualizado.setId(tituloId);
	    Titulo tituloExistente = new Titulo();
	    when(tituloDAO.findById(tituloId)).thenReturn(Optional.of(tituloExistente));

	    String view = gestorTitulos.actualizarTitulo(tituloActualizado);

	    assertEquals(tituloActualizado.getTitulo(), tituloExistente.getTitulo());
	    assertEquals(tituloActualizado.getIsbn(), tituloExistente.getIsbn());
	    assertEquals(tituloActualizado.getNumReserva(), tituloExistente.getNumReserva());
	    verify(tituloDAO, times(1)).save(tituloExistente);
	    assertEquals("redirect:/vista-titulo", view);
	}

	@Test
	public void testBorrarTitulo() {
	    Long tituloId = 1L;
	    Titulo titulo = new Titulo();
	    when(tituloDAO.findById(tituloId)).thenReturn(Optional.of(titulo));

	    String view = gestorTitulos.borrarTitulo(tituloId, model);

	    verify(tituloDAO, times(1)).delete(titulo);
	    assertEquals("redirect:/vista-titulo", view);
	}

	@Test
	public void testBajaEjemplar() {
	    Long tituloId = 1L;
	    int numEjemplares = 1;
	    Titulo titulo = new Titulo();
	    when(tituloDAO.findById(tituloId)).thenReturn(Optional.of(titulo));
	    Ejemplar ejemplar = new Ejemplar();
	    when(ejemplarDAO.findById(tituloId)).thenReturn(Optional.of(ejemplar));

	    String view = gestorTitulos.bajaEjemplar(tituloId, numEjemplares);

	    assertTrue(titulo.getEjemplares().isEmpty());
	    verify(ejemplarDAO, times(1)).delete(ejemplar);
	    assertEquals("redirect:/vista-titulo", view);
	}

}
