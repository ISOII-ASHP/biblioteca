package com.ASHP.library.business.entity;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "RESERVA")
public class Reserva {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private Date fecha;
	@ManyToOne
	@JoinColumn(name = "USUARIO_id")
	public Usuario usuario;
	@ManyToOne
	@JoinColumn(name = "TITULO_id")
	public Titulo titulo;

	public Reserva() {
	}

	public Reserva(Date fecha, Usuario usuario, Titulo titulo) {
		super();
		this.fecha = fecha;
		this.usuario = usuario;
		this.titulo = titulo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
		return "Reserva [id=" + id + ", fecha=" + fecha + ", usuario=" + usuario + ", titulo=" + titulo + "]";
	}

}