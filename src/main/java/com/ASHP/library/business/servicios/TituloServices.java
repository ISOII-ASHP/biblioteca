package com.ASHP.library.business.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ASHP.library.business.entity.Titulo;
import com.ASHP.library.business.persistence.TituloDAO;



@Service
public class TituloServices{

	private TituloDAO tituloDAO;
	
	public Titulo save(Titulo titulo){
		return tituloDAO.save(titulo);
	}
	public void deleteById(Long id){
		tituloDAO.deleteById(id);
	}
	
	public List<Titulo> findAll(){
		return tituloDAO.findAll();
	}
	
	public Optional<Titulo> findById(Long id){
		return tituloDAO.findById(id);
	}
}