package com.ASHP.library.business.entity;

import jakarta.persistence.Entity;

@Entity
public class Revista extends Titulo {

	public Revista() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Revista [autores=" + autores + ", ejemplares=" + ejemplares + ", prestamos=" + prestamos + ", reservas="
				+ reservas + "]";
	}

}