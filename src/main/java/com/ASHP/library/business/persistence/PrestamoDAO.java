package com.ASHP.library.business.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ASHP.library.business.entity.Ejemplar;
import com.ASHP.library.business.entity.Prestamo;

@Repository
public interface PrestamoDAO extends JpaRepository<Prestamo, Long> {

	@Query("SELECT p FROM Prestamo p " +
           "WHERE p.ejemplar = :ejemplar " +
           "AND p.activo = true")
    Prestamo findPrestamoActivoPorEjemplar(@Param("ejemplar") Ejemplar ejemplar);
}