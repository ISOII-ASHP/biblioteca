package domain.entities;

import java.util.Vector;
import domain.entities.Prestamo;
import domain.entities.Reserva;

public class Usuario {
	private String _id;
	private String _nombre;
	private String _apellidos;
	private Date _fechaFinPenalizacion;
	private Object _attribute;
	public Vector<Prestamo> _prestamos = new Vector<Prestamo>();
	public Vector<Reserva> _reservas = new Vector<Reserva>();
}