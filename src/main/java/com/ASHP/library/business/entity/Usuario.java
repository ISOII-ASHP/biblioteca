package com.ASHP.library.business.entity;

import java.util.Date;
import java.util.Vector;

import com.ASHP.library.business.entity.Prestamo;
import com.ASHP.library.business.entity.Reserva;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;
	private String nombre;
	private String apellidos;
	private Date fechaFinPenalizacion;
	private Object attribute;
	public Vector<Prestamo> prestamos = new Vector<Prestamo>();
	public Vector<Reserva> reservas = new Vector<Reserva>();

	public Usuario() {
	}

	public Usuario(String nombre, String apellidos, Date fechaFinPenalizacion, Object attribute,
			Vector<Prestamo> prestamos, Vector<Reserva> reservas) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fechaFinPenalizacion = fechaFinPenalizacion;
		this.attribute = attribute;
		this.prestamos = prestamos;
		this.reservas = reservas;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public Date getFechaFinPenalizacion() {
		return fechaFinPenalizacion;
	}

	public void setFechaFinPenalizacion(Date fechaFinPenalizacion) {
		this.fechaFinPenalizacion = fechaFinPenalizacion;
	}

	public Object getAttribute() {
		return attribute;
	}

	public void setAttribute(Object attribute) {
		this.attribute = attribute;
	}

	public Vector<Prestamo> getPrestamos() {
		return prestamos;
	}

	public void setPrestamos(Vector<Prestamo> prestamos) {
		this.prestamos = prestamos;
	}

	public Vector<Reserva> getReservas() {
		return reservas;
	}

	public void setReservas(Vector<Reserva> reservas) {
		this.reservas = reservas;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", fechaFinPenalizacion="
				+ fechaFinPenalizacion + ", attribute=" + attribute + ", prestamos=" + prestamos + ", reservas="
				+ reservas + "]";
	}

}