package com.ASHP.library.business.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ASHP.library.business.entity.Libro;
import com.ASHP.library.business.persistence.LibroDAO;

@Service
public class LibroServices{

	private LibroDAO libroDAO;
	
	public Libro save(Libro libro){
		return libroDAO.save(libro);
	}
	public void deleteById(Long id){
		libroDAO.deleteById(id);
	}
	
	public List<Libro> findAll(){
		return libroDAO.findAll();
	}
	
	public Optional<Libro> findById(Long id){
		return libroDAO.findById(id);
	}
}