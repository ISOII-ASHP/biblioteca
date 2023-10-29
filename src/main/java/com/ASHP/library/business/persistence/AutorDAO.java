package com.ASHP.library.business.persistence;

import org.springframework.data.jpa.Repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ASHP.library.business.entity.Autor;

@Repository
public class AutorDAO extends JpaRepository<Autor> {

	public Object select(String aId) {
		throw new UnsupportedOperationException();
	}

	public int insert(Object aObject) {
		throw new UnsupportedOperationException();
	}

	public int update(Object aObject) {
		throw new UnsupportedOperationException();
	}

	public int delete(Object aObject) {
		throw new UnsupportedOperationException();
	}
}