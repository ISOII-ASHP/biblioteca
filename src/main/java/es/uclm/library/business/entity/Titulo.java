package es.uclm.library.business.entity;

import java.util.Vector;
import es.uclm.library.business.entity.Autor;
import es.uclm.library.business.entity.Ejemplar;
import es.uclm.library.business.entity.Prestamo;
import es.uclm.library.business.entity.Reserva;

public class Titulo {
	private String _titulo;
	private String _isbn;
	private String _numReserva;
	public Vector<Autor> _autores = new Vector<Autor>();
	public Vector<Ejemplar> _ejemplares = new Vector<Ejemplar>();
	public Vector<Prestamo> _prestamos = new Vector<Prestamo>();
	public Vector<Reserva> _reservas = new Vector<Reserva>();
}