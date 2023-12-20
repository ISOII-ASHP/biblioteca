package com.ASHP.library.business.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

	@Autowired
	public GestorPenalizaciones gestorPenalizaciones;
	
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
	
	public void validarUsuario(Usuario u, List<String> errores) {
		
		if ( u.getPrestamos().size() >= 4 ) {
			errores.add("Usuario supera el límite de préstamos (4)");
		
		} else if ( gestorPenalizaciones.comprobarPenalizacion(u) ) {
			errores.add("Usuario penalizado. No se le puede prestar más hasta: " + 
							u.getFechaFinPenalizacion());
		}
	}

	public void validarEjemplar(Ejemplar u, List<String> errores) {
		if (!ejemplarDAO.isEjemplarDisponible(u)) {
			errores.add(
				"El ejemplar " + u.getId() + " no se encuentra disponible"
			);
		}
	}

	@PostMapping("/nuevo-prestamo")
	public String postNuevoPrestamo(
		@RequestParam Long usuario, 
		@RequestParam Long titulo, 
		@RequestParam Optional<Long> ejemplar, 
		Model model) {

		ArrayList<String> errores = new ArrayList<>();
		model.addAttribute("errores", errores);
			
		Optional<Titulo> tOptional = tituloDAO.findById(titulo);
		Titulo t = tOptional.get();
		Optional<Usuario> uOptional = usuarioDAO.findById(usuario);
		Usuario u = uOptional.get();

		validarUsuario(u, errores);

		/**
		 * Si solo se recibe Usuario y Titulo, se muestra el selector con
		 * los ejemplares disponibles. Pero si se recibe también ejemplar,
		 * se intenta crear el préstamo.
		 */
		if (ejemplar.isPresent()) {
			Optional<Ejemplar> eOptional = ejemplarDAO.findById(ejemplar.get());
			Ejemplar e = eOptional.get();
			validarEjemplar(e, errores);
			if (errores.isEmpty()) {
				realizarPrestamo(u, t, e);
				return "confirmacion-prestamo.html";
			}
		}

		List<Ejemplar> ejemplares = ejemplarDAO.findEjemplaresDisponibles(t);
		if ( ejemplares.isEmpty() ) {
			errores.add("No hay ejemplares disponibles");
		}

		if (!errores.isEmpty()) {
			List<Titulo> todosLosTitulos = tituloDAO.findAll();
			List<Usuario> todosLosUsuarios = usuarioDAO.findAll();
			model.addAttribute("titulos", todosLosTitulos);
			model.addAttribute("usuarios", todosLosUsuarios);
			model.addAttribute("tituloYUsuarioSeleccionado", false);
		} else {
			model.addAttribute("tituloYUsuarioSeleccionado", true);
		}
		
		model.addAttribute("ejemplares", ejemplares);
		model.addAttribute("titulo", t);
		model.addAttribute("usuario", u);

		return "nuevo-prestamo";
	}

	public Prestamo realizarPrestamo(Usuario usuario, Titulo titulo, Ejemplar ejemplar) {
		Prestamo p = Prestamo.prestamoDeDiasDesdeHoy(7, usuario, titulo, ejemplar);
		prestamoDAO.save(p);
		return p;
	}

	@GetMapping("/devolucion")
	public String vistaDevolucion() {
		
		return "devolucion";
	}

	@PostMapping("/devolucion")
	public String postDevolucion(@RequestParam Long id, Model model) {
		Optional<Ejemplar> ejemplarOpt = ejemplarDAO.findById(id);

		ArrayList<String> errores = new ArrayList<>();

		if (ejemplarOpt.isPresent()) {
			realizarDevolucion(ejemplarOpt.get());
		} else {
			errores.add("No se encontró ejemplar con ID " + id);
		}

		model.addAttribute("errores", errores);
		return "devolucion";
	}

	public void realizarDevolucion(Ejemplar ejemplar) {
		Prestamo prestamoActivo = 
				prestamoDAO.findPrestamoActivoPorEjemplar(ejemplar);

		prestamoActivo.setActivo(false);
		Date fechaActual = new Date();
		Date fechaFin = prestamoActivo.getFechaFin();
		if (fechaActual.compareTo(fechaFin) > 0) {
			gestorPenalizaciones.aplicarPenalizacion(prestamoActivo.getUsuario());
		}

		prestamoDAO.save(prestamoActivo);
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