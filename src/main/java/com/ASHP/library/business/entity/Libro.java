package com.ASHP.library.business.entity;

import jakarta.persistence.Entity;

@Entity
public class Libro extends Titulo {

	public Libro() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Libro [autores=" + autores + ", ejemplares=" + ejemplares + ", prestamos=" + prestamos + ", reservas="
				+ reservas + "]";
	}
	
}