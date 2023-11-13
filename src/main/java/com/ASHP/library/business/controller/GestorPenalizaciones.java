package com.ASHP.library.business.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.ASHP.library.business.entity.Usuario;
import com.ASHP.library.business.persistence.UsuarioDAO;

@Controller
public class GestorPenalizaciones {
	private static final Logger log = LoggerFactory.getLogger(GestorPenalizaciones.class);

	@Autowired
	public UsuarioDAO _usuarioDAO;

	public void aplicarPenalizacion(Usuario aU) {
		throw new UnsupportedOperationException();
	}

	public void comprobarPenalizacion(Usuario aU) {
		throw new UnsupportedOperationException();
	}
}