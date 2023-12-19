package com.ASHP.library.business.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ASHP.library.business.entity.Autor;
import com.ASHP.library.business.entity.Ejemplar;
import com.ASHP.library.business.entity.Prestamo;
import com.ASHP.library.business.entity.Reserva;
import com.ASHP.library.business.entity.Titulo;
import com.ASHP.library.business.entity.Usuario;
import com.ASHP.library.business.persistence.EjemplarDAO;
import com.ASHP.library.business.persistence.PrestamoDAO;
import com.ASHP.library.business.persistence.ReservaDAO;
import com.ASHP.library.business.persistence.TituloDAO;
import com.ASHP.library.business.persistence.UsuarioDAO;

@Controller
public class GestorPrestamos {
	private static final Logger log = LoggerFactory.getLogger(GestorPrestamos.class);

	@Autowired
	public PrestamoDAO prestamoDAO;
	@Autowired
	public ReservaDAO reservaDAO;
	@Autowired
	public TituloDAO tituloDAO;
	@Autowired
	public EjemplarDAO ejemplarDAO;

	@Autowired
	public UsuarioDAO usuarioDAO;

	@GetMapping("/prestamo")
	public String menuPrestamos() {
		return "prestamo";
	}

	@GetMapping("/nuevo-prestamo")
	public String menuNuevoPrestamo(Model model) {
		List<Titulo> todosLosTitulos = tituloDAO.findAll();
		List<Usuario> todosLosUsuarios = usuarioDAO.findAll();
		model.addAttribute("titulos", todosLosTitulos);
		model.addAttribute("usuarios", todosLosUsuarios);

		return "nuevo-prestamo";
	}

	@PostMapping("/nuevo-prestamo")
	public String postNuevoPrestamo(@RequestParam Long usuario, @RequestParam Long titulo, Model model) {
		// Obtener el título por su ID
		Optional<Titulo> tOptional = tituloDAO.findById(titulo);
		Titulo t = tOptional.get();

		// Obtener el usuario por su ID
		Optional<Usuario> uOptional = usuarioDAO.findById(usuario);
		Usuario u = uOptional.get();

		ArrayList<String> errores = new ArrayList();

		// FIXME: establecer ese 4 de alguna propiedad MAX_PRESTAMOS
		// de alguna constante, algún fichero de config, vars. de entorno...
		if (u.getPrestamos().size() >= 4) {
			errores.add("Usuario supera el límite de préstamos (4)");
			// TODO: comparar esta fecha con el día de hoy.
		} else if (u.getFechaFinPenalizacion() != null) {
			errores.add("Usuario penalizado. No se le puede prestar más hasta: " + u.getFechaFinPenalizacion());
		}

		List<Ejemplar> ejemplares = ejemplarDAO.findEjemplaresDisponibles(t);
		System.out.println(ejemplares);
		if (ejemplares.size() == 0) {
			errores.add("No hay ejemplares disponibles");
		}

		if (errores.size() > 0) {
			List<Titulo> todosLosTitulos = tituloDAO.findAll();
			List<Usuario> todosLosUsuarios = usuarioDAO.findAll();
			model.addAttribute("titulos", todosLosTitulos);
			model.addAttribute("usuarios", todosLosUsuarios);

			model.addAttribute("errores", errores);
			model.addAttribute("seleccionado", false);
		} else {
			model.addAttribute("seleccionado", true);
		}

		model.addAttribute("errores", errores);
		model.addAttribute("ejemplares", ejemplares);
		model.addAttribute("titulo", t);
		model.addAttribute("usuario", u);

		return "nuevo-prestamo";
	}

	@PostMapping("/crear-prestamo")
	public String realizarPrestamo(@RequestParam Long usuario, @RequestParam Long titulo, @RequestParam Long ejemplar) {
		// Obtener el título por su ID
		Optional<Titulo> tOptional = tituloDAO.findById(titulo);
		Titulo t = tOptional.get();

		// Obtener el usuario por su ID
		Optional<Usuario> uOptional = usuarioDAO.findById(usuario);
		Usuario u = uOptional.get();

		// Obtener el ejemplar por su ID
		Optional<Ejemplar> eOptional = ejemplarDAO.findById(ejemplar);
		Ejemplar e = eOptional.get();

		// Obtener fechas de inicio y de fin
		Date fechaInicio = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(fechaInicio);
		calendar.add(Calendar.DAY_OF_YEAR, 7);
		Date fechaFin = calendar.getTime();

		Prestamo p = new Prestamo(fechaInicio, fechaFin, true, u, t, e);
		prestamoDAO.save(p);

		return "confirmacion-prestamo";
	}

	public void realizarDevolucion(String aIsbn, String aIdEjemplar, String aIdUsuario) {
		throw new UnsupportedOperationException();
	}
	
	
	// Método para reservar un título
	@PostMapping("/reservarEjemplar")
	public String reservaEjemplar(Model model, @RequestParam("titulo") Long tituloId, @RequestParam("usuario") Long usuarioId) {
		// Obtener el título por su ID
	    Optional<Titulo> tOptional = tituloDAO.findById(tituloId);
	    Titulo t = tOptional.get();

	    // Obtener el usuario por su ID
	    Optional<Usuario> uOptional = usuarioDAO.findById(usuarioId);

	    Usuario u = uOptional.get();

	    // Comprobar si hay ejemplares disponibles
	    List<Ejemplar> ejemplares = t.getEjemplares();

	    if (ejemplares.isEmpty()) {
	        mensaje("No hay ejemplares disponibles de este título.", model);
	    } else {
	        // Obtener un ejemplar de la lista
	        Ejemplar ejemplarParaReservar = ejemplares.get(0);

	        // Si hay ejemplares disponibles, realizar la reserva
	        Reserva reserva = new Reserva();
	        reserva.setTitulo(t);
	        reserva.setUsuario(u);
	        Date fechaInicio = new Date();
	        java.sql.Date sqlDate = new java.sql.Date(fechaInicio.getTime());
	        reserva.setFecha(sqlDate); // Fecha actual
	        reservaDAO.save(reserva);

	        // Eliminar el ejemplar reservado de la base de datos
	        ejemplarDAO.delete(ejemplarParaReservar);

	        mensaje("Reserva realizada con éxito.", model);
	    }

	    return "reservar-ejemplar";

	}

	
	@GetMapping("/reservarEjemplar")
	public String reservarEjemplar(Model model) {
		List<Titulo> titulos = tituloDAO.findAll();
		List<Usuario> usuarios = usuarioDAO.findAll();
		
		model.addAttribute("titulos", titulos);
		model.addAttribute("usuarios", usuarios);
		return "reservar-ejemplar";
	}

	public <T> List<T> optionalToList(Optional<T> optional) {
		List<T> list = new ArrayList<>();
		optional.ifPresent(list::add);
		return list;
	}
	
	public void mensaje(String mensaje, Model model) {
		model.addAttribute("mensaje", mensaje);
		reservarEjemplar(model);
	}
}