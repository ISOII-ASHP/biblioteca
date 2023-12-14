package com.ASHP.library.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ASHP.library.business.entity.Autor;
import com.ASHP.library.business.entity.Ejemplar;
import com.ASHP.library.business.entity.Titulo;
import com.ASHP.library.business.persistence.AutorDAO;
import com.ASHP.library.business.persistence.EjemplarDAO;
import com.ASHP.library.business.persistence.TituloDAO;

public class TestRepoInitializer {
    public static void initRepos(EjemplarDAO ejemplarDAO,
                          TituloDAO tituloDAO,
                          AutorDAO autorDAO) {
        Titulo[] titulos = {
            new Titulo("Título 1",  "isbn1111", "r1111"),
            new Titulo("Título 2", "isbn2222", "r2222")
        };

        Autor[] autores = {
            new Autor("Autor 1", "Primer autor", List.of(titulos[0])),
            new Autor("Autor 2", "Segundo autor", List.of(titulos[1]))
        };

        Ejemplar[] ejemplares = {
            new Ejemplar(titulos[0]),
            new Ejemplar(titulos[0]),
            new Ejemplar(titulos[0]),
            new Ejemplar(titulos[1]),
            new Ejemplar(titulos[1])
        };

        tituloDAO.saveAll(List.of(titulos));
        ejemplarDAO.saveAll(List.of(ejemplares));
        autorDAO.saveAll(List.of(autores));
    }
}
