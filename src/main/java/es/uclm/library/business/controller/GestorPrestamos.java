package es.uclm.library.business.controller;

import es.uclm.library.business.persistence.PrestamoDAO;
import es.uclm.library.business.persistence.ReservaDAO;

public class GestorPrestamos {
	public PrestamoDAO _prestamoDAO;
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