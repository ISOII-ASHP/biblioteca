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
import com.ASHP.library.business.persistence.TituloDAO;


@Controller
public class GestorTitulos {

	private static final Logger log = LoggerFactory.getLogger(GestorTitulos.class);

	@Autowired
	public TituloDAO tituloDAO;
//	@Autowired
//	public EjemplarDAO _ejemplarDAO;
//	@Autowired
//	public AutorDAO _autorDAO;

	// @Autowired
	// private TituloServices tituloService;

	@Autowired
	private AutorDAO autorDAO;

	public GestorTitulos(TituloDAO tituloDAO, AutorDAO autorDAO) {

		super();
		this.tituloDAO = tituloDAO;

		this.autorDAO = autorDAO;

	}

	@PostMapping("/altaTitulo")
	public String altaTitulo(@RequestParam List<String> titulo, @RequestParam List<String> autor, Model model) {

		String nombreTitulo, numReserva, isbn, nombreAutor, apellidoAutor;

		nombreTitulo = titulo.get(0);
		isbn = titulo.get(1);
		numReserva = titulo.get(2);

		Titulo t = new Titulo(nombreTitulo, isbn, numReserva);
		Ejemplar e = new Ejemplar(t);

		nombreAutor = autor.get(0);
		apellidoAutor = autor.get(1);
		List<Titulo> titulos = new ArrayList<Titulo>();
		titulos.add(t);
		Autor a = new Autor(nombreAutor, apellidoAutor, titulos);

		model.addAttribute("titulo", titulo);
		//tituloDAO.save(titulo);
		return "vista-titulo";
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

	@PostMapping("/altaEjemplar")
	public String altaEjemplar(@ModelAttribute("ejemplar") Ejemplar ejemplar, @RequestParam("tituloId") Long tituloId) {
	    Titulo titulo = tituloDAO.findById(tituloId).orElseThrow(() -> new IllegalArgumentException("Invalid titulo Id:" + tituloId));
	    titulo.getEjemplares().add(ejemplar);
	    tituloDAO.save(titulo);
	    return "redirect:/vistaFormTituloAutor";
	}

	
	public void bajaEjemplar(Titulo aT) {
		throw new UnsupportedOperationException();
	}
}