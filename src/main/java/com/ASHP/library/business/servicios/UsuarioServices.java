package com.ASHP.library.business.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ASHP.library.business.entity.Usuario;
import com.ASHP.library.business.persistence.UsuarioDAO;



@Service
public class UsuarioServices{

	private UsuarioDAO usuarioDAO;
	
	public Usuario save(Usuario usuario){
		return usuarioDAO.save(usuario);
	}
	public void deleteById(Long id){
		usuarioDAO.deleteById(id);
	}
	
	public List<Usuario> findAll(){
		return usuarioDAO.findAll();
	}
	
	public Optional<Usuario> findById(Long id){
		return usuarioDAO.findById(id);
	}
}