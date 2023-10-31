package com.ASHP.library.business.persistence;

//import org.springframework.data.jpa.Repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ASHP.library.business.entity.Autor;

@Repository
public interface AutorDAO extends JpaRepository<Autor, Long> {

	public Object select(String aId);

	public int insert(Object aObject);

	public int update(Object aObject);

	@Override
	public void delete(Autor autor);
}