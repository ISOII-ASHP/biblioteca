package com.ASHP.library.business.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ASHP.library.business.entity.Prestamo;

@Repository
public interface PrestamoDAO extends JpaRepository<Prestamo, Long> {

	
}