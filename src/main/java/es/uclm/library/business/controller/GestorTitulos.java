package es.uclm.library.business.controller;

import es.uclm.library.business.entity.TituloDAO;
import es.uclm.library.business.entity.EjemplarDAO;
import es.uclm.library.business.entity.AutorDAO;
import es.uclm.library.business.entity.Titulo;

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