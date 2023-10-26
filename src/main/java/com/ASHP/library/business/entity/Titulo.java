package com.ASHP.library.business.entity;

import java.util.Vector;

import com.ASHP.library.business.entity.Autor;
import com.ASHP.library.business.entity.Ejemplar;
import com.ASHP.library.business.entity.Prestamo;
import com.ASHP.library.business.entity.Reserva;

public class Titulo {
	private String _titulo;
	private String _isbn;
	private String _numReserva;
	public Vector<Autor> _autores = new Vector<Autor>();
	public Vector<Ejemplar> _ejemplares = new Vector<Ejemplar>();
	public Vector<Prestamo> _prestamos = new Vector<Prestamo>();
	public Vector<Reserva> _reservas = new Vector<Reserva>();
}