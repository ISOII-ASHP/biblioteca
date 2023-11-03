package com.ASHP.library.business.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ASHP.library.business.entity.Prestamo;

import com.ASHP.library.business.persistence.PrestamoDAO;


@Service
public class PrestamoServices{

	private PrestamoDAO prestamoDAO;
	
	public Prestamo save(Prestamo prestamo){
		return prestamoDAO.save(prestamo);
	}
	public void deleteById(Long id){
		prestamoDAO.deleteById(id);
	}
	
	public List<Prestamo> findAll(){
		return prestamoDAO.findAll();
	}
	
	public Optional<Prestamo> findById(Long id){
		return prestamoDAO.findById(id);
	}
}