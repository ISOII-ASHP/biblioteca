package com.ASHP.library.business.entity;

import java.util.Vector;

import com.ASHP.library.business.entity.Titulo;

import jakarta.persistence.Entity;

@Entity
public class Autor {
	private String nombre;
	private String apellido;
	public Vector<Titulo> titulos = new Vector<Titulo>();

	public Autor() {

	}

	public Autor(String nombre, String apellido, Vector<Titulo> titulos) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.titulos = titulos;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Vector<Titulo> getTitulos() {
		return titulos;
	}

	public void setTitulos(Vector<Titulo> titulos) {
		this.titulos = titulos;
	}

	@Override
	public String toString() {
		return "Autor [nombre=" + nombre + ", apellido=" + apellido + ", titulos=" + titulos + "]";
	}

}