package com.ASHP.library.business.entity;

import java.util.Date;

import jakarta.persistence.Entity;

@Entity
public class Prestamo {
	private Date fechaInicio;
	private Date fechaFin;
	private Boolean activo;
	public Usuario usuario;
	public Titulo titulo;

	public Prestamo() {

	}

	public Prestamo(Date fechaInicio, Date fechaFin, Boolean activo, Usuario usuario, Titulo titulo) {
		super();
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.activo = activo;
		this.usuario = usuario;
		this.titulo = titulo;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public Boolean getActivo() {
		return activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
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
		return "Prestamo [fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + ", activo=" + activo + ", usuario="
				+ usuario + ", titulo=" + titulo + "]";
	}

}