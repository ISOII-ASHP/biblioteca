package com.ASHP.library.business.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ASHP.library.business.entity.Titulo;
import com.ASHP.library.business.persistence.AutorDAO;
import com.ASHP.library.business.persistence.EjemplarDAO;
import com.ASHP.library.business.persistence.TituloDAO;

@Controller
public class GestorTitulos {
	
	private static final Logger log = LoggerFactory.getLogger(GestorTitulos.class);
	
	@Autowired
	public TituloDAO _tituloDAO;
	@Autowired
	public EjemplarDAO _ejemplarDAO;
	@Autowired
	public AutorDAO _autorDAO;

	@PostMapping("/titulo")
	public String altaTitulo(@ModelAttribute Titulo titulo, Model model) {
		model.addAttribute("titulo", titulo);
		Titulo savedGreeting = _tituloDAO.save(titulo);
		log.info("Saved greeting: " + savedGreeting);
		return "vista-titulo";
	}
	
	@GetMapping("/titulo")
	public String verTitulo(Model model) {
	model.addAttribute("titulo", new Titulo());
	log.info(_tituloDAO.findAll().toString());
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