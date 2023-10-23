package com.ASHP.library.business.controller;

import com.ASHP.library.business.entity.Titulo;
import com.ASHP.library.business.persistence.AutorDAO;
import com.ASHP.library.business.persistence.EjemplarDAO;
import com.ASHP.library.business.persistence.TituloDAO;

public class GestorTitulos {
	public TituloDAO _tituloDAO;
	public EjemplarDAO _ejemplarDAO;
	public AutorDAO _autorDAO;

	public Titulo altaTitulo(String aTitulo, String aIsbn, String[] aAutores) {
		throw new UnsupportedOperationException();
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