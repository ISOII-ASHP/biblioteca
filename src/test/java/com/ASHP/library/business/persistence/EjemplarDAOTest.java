package com.ASHP.library.business.persistence;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.ASHP.library.business.TestRepoInitializer;
import com.ASHP.library.business.entity.Autor;
import com.ASHP.library.business.entity.Ejemplar;
import com.ASHP.library.business.entity.Titulo;


/**
 * Nota: solo probamos los métodos custom para asegurarnos de que hacen
 * lo que deben hacer. El resto de métodos autoimlpementados por JPA no debemos
 * testarlos (¡se supone que ya están testados!)
 */
@DataJpaTest()
public class EjemplarDAOTest {
    @Autowired
    EjemplarDAO ejemplarDAO;
    @Autowired
    TituloDAO tituloDAO;
    @Autowired
    AutorDAO autorDAO;


    @Autowired                  // Ambos para inicializar préstamos
    UsuarioDAO usuarioDAO;
    @Autowired
    PrestamoDAO prestamosDAO;

    @BeforeEach
    public void before(){
        TestRepoInitializer.initTitulos(ejemplarDAO, tituloDAO, autorDAO);
    }

    @Test
    void testFindByTitulo_deberia_devolver_todos_los_ejemplares_del_titulo() {
        // Given: t1 con 3 ejemplares  y t2 con 2 ejemplares
        List<Titulo> titulos = tituloDAO.findAll();

        // When:
        List<Ejemplar> ejemplaresT1 = ejemplarDAO.findByTitulo(titulos.get(0));
        List<Ejemplar> ejemplaresT2 = ejemplarDAO.findByTitulo(titulos.get(1));

        // Then:
        Assertions.assertEquals(3, ejemplaresT1.size());
        Assertions.assertEquals(2, ejemplaresT2.size());
    }   

    @Test
    void testFindEjemplaresDisponibles_devuelve_ejemplares_de_un_titulo_no_prestados() {
        TestRepoInitializer.initUsuarios(usuarioDAO); 
        TestRepoInitializer.initPrestamos(prestamosDAO);
        
        List<Ejemplar> disponibles = 
            ejemplarDAO.findEjemplaresDisponibles(TestRepoInitializer.titulos[0]);

        assertEquals(2, disponibles.size());
    }
}
