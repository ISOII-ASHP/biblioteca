package com.ASHP.library.business.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ASHP.library.business.entity.Ejemplar;
import com.ASHP.library.business.entity.Titulo;

@Repository
public interface EjemplarDAO extends JpaRepository<Ejemplar, Long> {
	List<Ejemplar> findByTitulo(Titulo titulo);

	@Query("SELECT e FROM Ejemplar e " +
           "WHERE e.titulo = :titulo " +
           "AND NOT EXISTS (SELECT p FROM Prestamo p WHERE p.ejemplar = e AND p.activo = true)")
	List<Ejemplar> findEjemplaresDisponibles(@Param("titulo") Titulo titulo);
}