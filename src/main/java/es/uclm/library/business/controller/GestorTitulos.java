package domain.controllers;

import persistencia.TituloDAO;
import persistencia.EjemplarDAO;
import persistencia.AutorDAO;
import domain.entities.Titulo;

public class GestorTitulos {
	public TituloDAO _tituloDAO;
	public EjemplarDAO _ejemplarDAO;
	public AutorDAO _autorDAO;

	public Titulo altaTítulo(String aTitulo, String aIsbn, String[] aAutores) {
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