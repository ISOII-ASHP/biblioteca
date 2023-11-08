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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ASHP.library.business.entity.Autor;
import com.ASHP.library.business.entity.Titulo;
import com.ASHP.library.business.persistence.AutorDAO;
import com.ASHP.library.business.persistence.EjemplarDAO;
import com.ASHP.library.business.persistence.TituloDAO;
import com.ASHP.library.business.servicios.AutorServices;
import com.ASHP.library.business.servicios.TituloServices;

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

	@GetMapping("/titulo")
	public String verTitulo(Model model) {
		List<Autor> autores = autorDAO.findAll();
	    Titulo titulo = new Titulo();
	    titulo.setAutores(new ArrayList<>());
	    model.addAttribute("titulo", titulo);
	    model.addAttribute("autores", autores);
		return "titulo";
	}

	@PostMapping("/titulo")
	public String altaTitulo(@ModelAttribute Titulo titulo, Model model) {
		model.addAttribute("titulo", titulo);
		tituloDAO.save(titulo);
		return "vista-titulo";
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