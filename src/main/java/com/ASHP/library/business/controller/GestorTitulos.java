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
	public String altaTitulo(@ModelAttribute Titulo titulo, Model model) {
		model.addAttribute("titulo",titulo);
		tituloDAO.save(titulo);
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

	@PostMapping("/altaTitulo")
	public String actualizarTitulo(Titulo titulo, Model model) {
		tituloDAO.findById(titulo.getId());
		tituloDAO.save(titulo);
		return "vista-titulo";
	}

	@PostMapping("/altaTitulo")
	public String borrarTitulo(@ModelAttribute Titulo titulo, Model model) {
		tituloDAO.delete(titulo);
		return "vista-titulo";
	}

	public void altaEjemplar(Titulo aT) {
		throw new UnsupportedOperationException();
	}

	public void bajaEjemplar(Titulo aT) {
		throw new UnsupportedOperationException();
	}
}