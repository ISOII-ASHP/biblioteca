package com.ASHP.library.business.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Ejemplar {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;

	public Titulo titulo;

	public Ejemplar() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Titulo getTitulo() {
		return titulo;
	}

	public void setTitulo(Titulo titulo) {
		this.titulo = titulo;
	}

	@Override
	public String toString() {
		return "Ejemplar [id=" + id + ", titulo=" + titulo + "]";
	}

}

//