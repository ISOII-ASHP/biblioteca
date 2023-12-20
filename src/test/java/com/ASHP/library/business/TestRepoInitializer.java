package com.ASHP.library.business;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.ASHP.library.business.entity.Autor;
import com.ASHP.library.business.entity.Ejemplar;
import com.ASHP.library.business.entity.Prestamo;
import com.ASHP.library.business.entity.Titulo;
import com.ASHP.library.business.entity.Usuario;
import com.ASHP.library.business.persistence.AutorDAO;
import com.ASHP.library.business.persistence.EjemplarDAO;
import com.ASHP.library.business.persistence.PrestamoDAO;
import com.ASHP.library.business.persistence.TituloDAO;
import com.ASHP.library.business.persistence.UsuarioDAO;

public class TestRepoInitializer {
    public static Titulo[] titulos;
    public static Autor[] autores;
    public static Ejemplar[] ejemplares;
    public static Usuario[] usuarios;
    public static Prestamo[] prestamos;


    public static void initTitulos(
        EjemplarDAO ejemplarDAO, 
        TituloDAO tituloDAO, 
        AutorDAO autorDAO) {

        ejemplarDAO.deleteAll();
        tituloDAO.deleteAll();
        autorDAO.deleteAll();


        titulos = new Titulo[]{
            new Titulo("Título 1",  "isbn1111", "r1111"),
            new Titulo("Título 2", "isbn2222", "r2222")
        };

        autores = new Autor[]{
            new Autor("Autor 1", "Primer autor", List.of(titulos[0])),
            new Autor("Autor 2", "Segundo autor", List.of(titulos[1]))
        };

        ejemplares = new Ejemplar[]{
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

    public static void initUsuarios(UsuarioDAO usuarioDAO) {
        usuarioDAO.deleteAll();

        usuarios = new Usuario[]{
            new Usuario("Usuario 1", "Apellidos 1"),
            new Usuario("Usuario 2", "Apellidos 2"),
        };

        usuarioDAO.saveAll(List.of(usuarios));
    }

    public static void initPrestamos(PrestamoDAO prestamoDAO) {
        prestamoDAO.deleteAll();

        Prestamo prestamoActivoNoPasado = // 3º ejemplar del primer título
            Prestamo.prestamoDeDiasDesdeHoy(7, usuarios[0], titulos[0], ejemplares[2]);
        
        Date hoy = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(hoy);
        calendar.add(Calendar.DAY_OF_YEAR, -10);
        Date fechaPasadaInicio = calendar.getTime();
        calendar.add(Calendar.DAY_OF_YEAR, 5);
        Date fechaPasadaFin = calendar.getTime();

        Prestamo prestamoActivoPasado =
            new Prestamo(
                fechaPasadaInicio, fechaPasadaFin,  true,
                usuarios[0], titulos[1], ejemplares[3]
            );

        Prestamo prestamoInactivoTerminado =
            new Prestamo(
                fechaPasadaInicio, fechaPasadaFin, false,
                usuarios[0], titulos[0], ejemplares[0]
            );

        prestamos = new Prestamo[]{
            prestamoActivoNoPasado,
            prestamoActivoPasado,
            prestamoInactivoTerminado
        };

        prestamoDAO.saveAll(List.of(prestamos));
    }
}
