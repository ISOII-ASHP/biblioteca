package com.ASHP.library.business.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ASHP.library.business.entity.Ejemplar;
import com.ASHP.library.business.persistence.EjemplarDAO;

@Service
public class EjemplarService{

	private EjemplarDAO ejemplarDAO;
	
	public Ejemplar save(Ejemplar ejemplar){
		return ejemplarDAO.save(ejemplar);
	}
	public void deleteById(Long id){
		ejemplarDAO.deleteById(id);
	}
	
	public List<Ejemplar> findAll(){
		return ejemplarDAO.findAll();
	}
	
	public Optional<Ejemplar> findById(Long id){
		return ejemplarDAO.findById(id);
	}
}