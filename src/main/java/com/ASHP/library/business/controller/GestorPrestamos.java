package com.ASHP.library.business.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ASHP.library.business.entity.Titulo;
import com.ASHP.library.business.entity.Usuario;
import com.ASHP.library.business.persistence.PrestamoDAO;
import com.ASHP.library.business.persistence.ReservaDAO;
import com.ASHP.library.business.persistence.TituloDAO;
import com.ASHP.library.business.persistence.UsuarioDAO;


@Controller
public class GestorPrestamos {
	private static final Logger log = LoggerFactory.getLogger(GestorPrestamos.class);

	@Autowired
	public PrestamoDAO _prestamoDAO;
	@Autowired
	public ReservaDAO _reservaDAO;
	@Autowired
	public TituloDAO _tituloDAO;
	@Autowired
	public UsuarioDAO _usuarioDAO;
	
	@GetMapping("/prestamo")
	public String menuPrestamos() { return "prestamo"; }
	
	@GetMapping("/nuevo-prestamo")
	public String menuNuevoPrestamo(Model model) {
		List<Titulo> todosLosTitulos = _tituloDAO.findAll();
		List<Usuario> todosLosUsuarios = _usuarioDAO.findAll();

		model.addAttribute("titulos", todosLosTitulos);
		model.addAttribute("usuarios", todosLosUsuarios);

		return "nuevo-prestamo";
	}


	public void realizarPrestamo(String aIsbn, String aIdEjemplar, String aIdUsuario) {
		throw new UnsupportedOperationException();
	}

	public void realizarDevolucion(String aIsbn, String aIdEjemplar, String aIdUsuario) {
		throw new UnsupportedOperationException();
	}

	public void realizarReserva(String aIdUsuario, String aIsbn) {
		throw new UnsupportedOperationException();
	}
}