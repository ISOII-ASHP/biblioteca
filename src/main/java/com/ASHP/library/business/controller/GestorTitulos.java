package com.ASHP.library.business.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ASHP.library.business.entity.Autor;
import com.ASHP.library.business.entity.Ejemplar;
import com.ASHP.library.business.entity.Titulo;
import com.ASHP.library.business.persistence.AutorDAO;
import com.ASHP.library.business.persistence.EjemplarDAO;
import com.ASHP.library.business.persistence.TituloDAO;

@Controller
public class GestorTitulos {


	@Autowired
	public TituloDAO tituloDAO;
	@Autowired
	public EjemplarDAO ejemplarDAO;
	@Autowired
	public AutorDAO autorDAO;

	// @Autowired
	// private TituloServices tituloService;

	public GestorTitulos(TituloDAO tituloDAO, AutorDAO autorDAO, EjemplarDAO ejemplarDAO) {

		super();
		this.tituloDAO = tituloDAO;

		this.autorDAO = autorDAO;

		this.ejemplarDAO = ejemplarDAO;

	}

	/**
	 * Metodo para dar de alta titulos con sus ejemplares y autores
	 * 
	 * @param titulo
	 * @param autor
	 * @param model
	 * @return
	 */

	@PostMapping("/altaTitulo")
	public String altaTitulo(@RequestParam List<String> titulo, @RequestParam List<String> autor, Model model) {

		String nombreTitulo, numReserva, isbn, nombreAutor, apellidoAutor;

		
		// Recojo los datos del formulario
		nombreAutor = autor.get(0);
		apellidoAutor = autor.get(1);

		Autor a = new Autor(nombreAutor, apellidoAutor);
		
		// Recojo los datos del formulario
		nombreTitulo = titulo.get(0);
		isbn = titulo.get(1);
		numReserva = titulo.get(2);

		// Creo los objetos
		Titulo t = new Titulo(nombreTitulo, isbn, numReserva);
		t.addAutor(a);
		

		// Guardo en la base de datos
		model.addAttribute("titulo", t);
		tituloDAO.save(t);
//		autorDAO.save(a);
		
		Titulo tituloPorNombre = getTituloByName(nombreTitulo);
		
		Ejemplar e = new Ejemplar(tituloPorNombre);
		List<Ejemplar> ejemplares = new ArrayList<Ejemplar>();
		ejemplares.add(e);
		
		tituloPorNombre.setEjemplares(ejemplares);
		ejemplarDAO.save(e);

		return "vista-titulo";
	}

	private Titulo getTituloByName(String nombreTitulo) {
		List<Titulo> t = tituloDAO.findAll();
		for (Titulo titulo : t) {
			if(titulo.getTitulo().equals(nombreTitulo))
				return titulo;
		}
		return null;
		
		
	}

	@GetMapping("/vistaFormTituloAutor")
	public String verFormulario(Model model) {
		Titulo titulo = new Titulo();
		Autor autor = new Autor();
		titulo.setAutores(new ArrayList<>());

		model.addAttribute("titulo", titulo);
		model.addAttribute("autor", autor);

		return "titulo";
	}

	public void actualizarTitulo(Titulo aT) {
		throw new UnsupportedOperationException();
	}

	public void borrarTitulo(Titulo aT) {
		throw new UnsupportedOperationException();
	}

	public void altaEjemplar(Titulo aT) {
		throw new UnsupportedOperationException();
	}

	public void bajaEjemplar(Titulo aT) {
		throw new UnsupportedOperationException();
	}
}