package com.ASHP.library.business.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Libro extends Titulo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	public Libro() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	@Override
	public String toString() {
		return "Libro [id=" + id + ", autores=" + autores + ", ejemplares=" + ejemplares + ", prestamos=" + prestamos
				+ ", reservas=" + reservas + "]";
	}

	
	
}