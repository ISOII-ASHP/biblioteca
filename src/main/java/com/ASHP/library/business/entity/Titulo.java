package com.ASHP.library.business.entity;

import java.util.Vector;

import com.ASHP.library.business.entity.Autor;
import com.ASHP.library.business.entity.Ejemplar;
import com.ASHP.library.business.entity.Prestamo;
import com.ASHP.library.business.entity.Reserva;

import jakarta.persistence.Entity;

@Entity
public class Titulo {
	private String titulo;
	private String isbn;
	private String numReserva;
	public Vector<Autor> autores = new Vector<Autor>();
	public Vector<Ejemplar> ejemplares = new Vector<Ejemplar>();
	public Vector<Prestamo> prestamos = new Vector<Prestamo>();
	public Vector<Reserva> reservas = new Vector<Reserva>();

	public Titulo() {
	}

	public Titulo(String titulo, String isbn, String numReserva, Vector<Autor> autores, Vector<Ejemplar> ejemplares,
			Vector<Prestamo> prestamos, Vector<Reserva> reservas) {
		super();
		this.titulo = titulo;
		this.isbn = isbn;
		this.numReserva = numReserva;
		this.autores = autores;
		this.ejemplares = ejemplares;
		this.prestamos = prestamos;
		this.reservas = reservas;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getNumReserva() {
		return numReserva;
	}

	public void setNumReserva(String numReserva) {
		this.numReserva = numReserva;
	}

	public Vector<Autor> getAutores() {
		return autores;
	}

	public void setAutores(Vector<Autor> autores) {
		this.autores = autores;
	}

	public Vector<Ejemplar> getEjemplares() {
		return ejemplares;
	}

	public void setEjemplares(Vector<Ejemplar> ejemplares) {
		this.ejemplares = ejemplares;
	}

	public Vector<Prestamo> getPrestamos() {
		return prestamos;
	}

	public void setPrestamos(Vector<Prestamo> prestamos) {
		this.prestamos = prestamos;
	}

	public Vector<Reserva> getReservas() {
		return reservas;
	}

	public void setReservas(Vector<Reserva> reservas) {
		this.reservas = reservas;
	}

	@Override
	public String toString() {
		return "Titulo [titulo=" + titulo + ", isbn=" + isbn + ", numReserva=" + numReserva + ", autores=" + autores
				+ ", ejemplares=" + ejemplares + ", prestamos=" + prestamos + ", reservas=" + reservas + "]";
	}

}