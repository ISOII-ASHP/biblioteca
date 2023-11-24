package com.ASHP.library.business.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "REVISTA")
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