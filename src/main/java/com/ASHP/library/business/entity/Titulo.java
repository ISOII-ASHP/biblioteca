package com.ASHP.library.business.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Transient;

@Entity
public class Titulo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private String titulo;
	@Column
	private String isbn;
	@Column
	private String numReserva;

	@ManyToMany
	public List<Autor> autores = new ArrayList<Autor>();
	@OneToMany
	public List<Ejemplar> ejemplares = new ArrayList<Ejemplar>();

	@OneToMany
	public List<Prestamo> prestamos = new ArrayList<Prestamo>();

	@OneToMany
	public List<Reserva> reservas = new ArrayList<Reserva>();

	public Titulo() {
	}

	public Titulo(String titulo, String isbn, String numReserva) {
		super();
		this.titulo = titulo;
		this.isbn = isbn;
		this.numReserva = numReserva;
	}

	public Titulo(String titulo, String isbn, String numReserva, List<Autor> autores, List<Ejemplar> ejemplares,
			List<Prestamo> prestamos, List<Reserva> reservas) {
		super();
		this.titulo = titulo;
		this.isbn = isbn;
		this.numReserva = numReserva;
		this.autores = autores;
		this.ejemplares = ejemplares;
		this.prestamos = prestamos;
		this.reservas = reservas;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public List<Autor> getAutores() {
		return autores;
	}

	public void setAutores(List<Autor> autores) {
		this.autores = autores;
	}

	public List<Ejemplar> getEjemplares() {
		return ejemplares;
	}

	public void setEjemplares(List<Ejemplar> ejemplares) {
		this.ejemplares = ejemplares;
	}

	public List<Prestamo> getPrestamos() {
		return prestamos;
	}

	public void setPrestamos(List<Prestamo> prestamos) {
		this.prestamos = prestamos;
	}

	public List<Reserva> getReservas() {
		return reservas;
	}

	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
	}

	@Override
	public String toString() {
		return "Titulo [id=" + id + ", titulo=" + titulo + ", isbn=" + isbn + ", numReserva=" + numReserva
				+ ", autores=" + autores + ", ejemplares=" + ejemplares + ", prestamos=" + prestamos + ", reservas="
				+ reservas + "]";
	}

}