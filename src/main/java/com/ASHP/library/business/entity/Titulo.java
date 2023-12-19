package com.ASHP.library.business.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "titulo")
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

	 @JoinTable(
	            name = "titulo_autor",
	            joinColumns = {@JoinColumn(name = "titulo_id")},
	            inverseJoinColumns = {@JoinColumn(name = "autor_id")}
	    )
	 @ManyToMany(cascade = {
	            CascadeType.ALL
	    })
	protected List<Autor> autores;
	
	@OneToMany(mappedBy = "titulo")
	protected List<Ejemplar> ejemplares = new ArrayList<Ejemplar>();

	@OneToMany(mappedBy = "titulo")
	protected List<Prestamo> prestamos = new ArrayList<Prestamo>();

	@OneToMany(mappedBy = "titulo")
	protected List<Reserva> reservas = new ArrayList<Reserva>();

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

	
	 public void addAutor(Autor autor){
	        if(this.autores == null){
	            this.autores = new ArrayList<>();
	        }
	        
	        this.autores.add(autor);
	    }
	 
	 
	public void addEjemplar(Ejemplar ejemplar) {
		if (this.ejemplares == null) {
			this.ejemplares = new ArrayList<>();
		}
		this.ejemplares.add(ejemplar);
	}
	
	public void removeEjemplar(Ejemplar ejemplar) {
	    if (this.ejemplares != null) {
	        this.ejemplares.remove(ejemplar);
	    }
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
	
}