package com.ASHP.library.business.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ASHP.library.business.entity.Autor;
import com.ASHP.library.business.persistence.AutorDAO;

@Service
public class AutorService{

	private AutorDAO autorDAO;
	
	public Autor save(Autor autor){
		return autorDAO.save(autor);
	}
	public void deleteById(Long id){
		autorDAO.deleteById(id);
	}
	
	public List<Autor> findAll(){
		return autorDAO.findAll();
	}
	
	public Optional<Autor> findById(Long id){
		return autorDAO.findById(id);
	}
}