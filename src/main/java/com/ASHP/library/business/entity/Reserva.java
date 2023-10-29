package com.ASHP.library.business.entity;

import java.sql.Date;

import jakarta.persistence.Entity;

@Entity
public class Reserva {
	private Date fecha;
	public Usuario usuario;
	public Titulo titulo;

	public Reserva() {
	}

	public Reserva(Date fecha, Usuario usuario, Titulo titulo) {
		super();
		this.fecha = fecha;
		this.usuario = usuario;
		this.titulo = titulo;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Titulo getTitulo() {
		return titulo;
	}

	public void setTitulo(Titulo titulo) {
		this.titulo = titulo;
	}

	@Override
	public String toString() {
		return "Reserva [fecha=" + fecha + ", usuario=" + usuario + ", titulo=" + titulo + "]";
	}

}