package com.ASHP.library.business.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ASHP.library.business.entity.Reserva;
import com.ASHP.library.business.persistence.ReservaDAO;



@Service
public class ReservaServices{

	private ReservaDAO reservaDAO;
	
	public Reserva save(Reserva reserva){
		return reservaDAO.save(reserva);
	}
	public void deleteById(Long id){
		reservaDAO.deleteById(id);
	}
	
	public List<Reserva> findAll(){
		return reservaDAO.findAll();
	}
	
	public Optional<Reserva> findById(Long id){
		return reservaDAO.findById(id);
	}
}