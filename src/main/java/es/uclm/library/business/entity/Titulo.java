package domain.entities;

import java.util.Vector;
import domain.entities.Autor;
import domain.entities.Ejemplar;
import domain.entities.Prestamo;
import domain.entities.Reserva;

public class Titulo {
	private String _titulo;
	private String _isbn;
	private String _numReserva;
	public Vector<Autor> _autores = new Vector<Autor>();
	public Vector<Ejemplar> _ejemplares = new Vector<Ejemplar>();
	public Vector<Prestamo> _prestamos = new Vector<Prestamo>();
	public Vector<Reserva> _reservas = new Vector<Reserva>();
}