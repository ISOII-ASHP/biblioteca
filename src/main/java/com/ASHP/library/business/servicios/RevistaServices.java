package com.ASHP.library.business.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ASHP.library.business.entity.Revista;
import com.ASHP.library.business.persistence.RevistaDAO;


@Service
public class RevistaServices{

	private RevistaDAO revistaDAO;
	
	public Revista save(Revista revista){
		return revistaDAO.save(revista);
	}
	public void deleteById(Long id){
		revistaDAO.deleteById(id);
	}
	
	public List<Revista> findAll(){
		return revistaDAO.findAll();
	}
	
	public Optional<Revista> findById(Long id){
		return revistaDAO.findById(id);
	}
}