package com.ASHP.library.business.controller;

import java.util.Calendar;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.ASHP.library.business.entity.Prestamo;
import com.ASHP.library.business.entity.Usuario;
import com.ASHP.library.business.persistence.UsuarioDAO;

@Controller
public class GestorPenalizaciones {
	private static final Logger log = LoggerFactory.getLogger(GestorPenalizaciones.class);

	@Autowired
	public UsuarioDAO _usuarioDAO;

	public void aplicarPenalizacion(Usuario usuario) {
		Date fechaActual = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(fechaActual);
		calendar.add(Calendar.DAY_OF_YEAR, 30); // 30 días desde hoy
		Date fechaPenalizacion = calendar.getTime();

		usuario.setFechaFinPenalizacion(fechaPenalizacion);
		_usuarioDAO.save(usuario);
	}

	/**
	 * @param usuario usuario a comprobar
	 * @return true si está penalizado, false si no.
	 */
	public boolean comprobarPenalizacion(Usuario usuario) {
		return usuario.getFechaFinPenalizacion() != null
			&& usuario.getFechaFinPenalizacion().compareTo(new Date()) > 0;
	}
}