package com.ASHP.library.business.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ASHP.library.business.entity.Revista;

@Repository
public interface RevistaDAO extends JpaRepository<Revista, Long> {
	
}
