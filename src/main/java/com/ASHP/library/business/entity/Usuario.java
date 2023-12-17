package com.ASHP.library.business.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Transient;

@Entity
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private String nombre;
	@Column
	private String apellidos;
	@Column
	private Date fechaFinPenalizacion;
		
    @OneToMany
	public List<Prestamo> prestamos = new ArrayList<Prestamo>();
    
    @OneToMany
	public List<Reserva> reservas = new ArrayList<Reserva>();

	public Usuario() {
	}

	public Usuario(String nombre, String apellidos) {
		this(nombre, apellidos, null, List.of(), List.of());
	}

	public Usuario(String nombre, String apellidos, Date fechaFinPenalizacion,
			List<Prestamo> prestamos, List<Reserva> reservas) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fechaFinPenalizacion = fechaFinPenalizacion;
		this.prestamos = prestamos;
		this.reservas = reservas;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public List<Prestamo> getPrestamos() {
		return prestamos;
	}

	public void setPrestamos(List<Prestamo> prestamos) {
		this.prestamos = prestamos;
	}

	public List<Reserva> getReservas() {
		return reservas;
	}

	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", fechaFinPenalizacion="
				+ fechaFinPenalizacion + ", prestamos=" + prestamos + ", reservas=" + reservas + "]";
	}

	
}