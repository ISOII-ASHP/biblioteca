package com.ASHP.library.business.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ASHP.library.business.entity.Titulo;

@Repository
public interface TituloDAO extends JpaRepository<Titulo, Long> {

	public Object select(String aId);

	public int insert(Object aObject);

	public int update(Object aObject);

	public void delete(Titulo titulo);
}