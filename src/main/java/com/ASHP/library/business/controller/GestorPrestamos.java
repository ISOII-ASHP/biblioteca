package com.ASHP.library.business.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.ASHP.library.business.persistence.PrestamoDAO;
import com.ASHP.library.business.persistence.ReservaDAO;

@Controller
public class GestorPrestamos {
	private static final Logger log = LoggerFactory.getLogger(GestorPrestamos.class);

	@Autowired
	public PrestamoDAO _prestamoDAO;
	@Autowired
	public ReservaDAO _reservaDAO;

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