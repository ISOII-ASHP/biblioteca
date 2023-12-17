package com.ASHP.library.business.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ASHP.library.business.entity.Ejemplar;
import com.ASHP.library.business.entity.Prestamo;
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
	public GestorPenalizaciones gestorPenalizaciones;

	@Autowired
	public PrestamoDAO _prestamoDAO;
	@Autowired
	public ReservaDAO _reservaDAO;
	@Autowired
	public TituloDAO _tituloDAO;
	@Autowired
	public EjemplarDAO _ejemplarDAO;

	@Autowired
	public UsuarioDAO _usuarioDAO;

	@GetMapping("/prestamo")
	public String menuPrestamos() { return "prestamo"; }

	@GetMapping("/nuevo-prestamo")
	public String menuNuevoPrestamo(Model model) {
		List<Titulo> todosLosTitulos = _tituloDAO.findAll();
		List<Usuario> todosLosUsuarios = _usuarioDAO.findAll();
		model.addAttribute("titulos", todosLosTitulos);
		model.addAttribute("usuarios", todosLosUsuarios);

		return "nuevo-prestamo";
	}

	public void validarUsuario(Usuario u, ArrayList<String> errores) {
		// FIXME: establecer ese 4 de alguna propiedad MAX_PRESTAMOS
		// de alguna constante, algún fichero de config, vars. de entorno...
		if ( u.getPrestamos().size() >= 4 ) {
			errores.add("Usuario supera el límite de préstamos (4)");
		// TODO: comparar esta fecha con el día de hoy.
		} else if ( gestorPenalizaciones.comprobarPenalizacion(u) ) {
			errores.add("Usuario penalizado. No se le puede prestar más hasta: " + 
							u.getFechaFinPenalizacion());
		}
	}

	public void validarEjemplar(Ejemplar u, ArrayList<String> errores) {
		if (!_ejemplarDAO.isEjemplarDisponible(u)) {
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
			
		Optional<Titulo> tOptional = _tituloDAO.findById(titulo);
		Titulo t = tOptional.get();
		Optional<Usuario> uOptional = _usuarioDAO.findById(usuario);
		Usuario u = uOptional.get();

		validarUsuario(u, errores);

		/**
		 * Si solo se recibe Usuario y Titulo, se muestra el selector con
		 * los ejemplares disponibles. Pero si se recibe también ejemplar,
		 * se intenta crear el préstamo.
		 */
		if (ejemplar.isPresent()) {
			Optional<Ejemplar> eOptional = _ejemplarDAO.findById(ejemplar.get());
			Ejemplar e = eOptional.get();
			validarEjemplar(e, errores);
			if (errores.size() == 0) {
				realizarPrestamo(u, t, e);
				return "confirmacion-prestamo.html";
			}
		}

		List<Ejemplar> ejemplares = _ejemplarDAO.findEjemplaresDisponibles(t);
		if ( ejemplares.size() == 0 ) {
			errores.add("No hay ejemplares disponibles");
		}

		if (errores.size() > 0) {
			List<Titulo> todosLosTitulos = _tituloDAO.findAll();
			List<Usuario> todosLosUsuarios = _usuarioDAO.findAll();
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

	@GetMapping("/devolucion")
	public String vistaDevolucion() {
		
		return "devolucion";
	}

	@PostMapping("/devolucion")
	public String postDevolucion(@RequestParam Long id, Model model) {
		Optional<Ejemplar> ejemplarOpt = _ejemplarDAO.findById(id);

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
				_prestamoDAO.findPrestamoActivoPorEjemplar(ejemplar);

		prestamoActivo.setActivo(false);
		Date fechaActual = new Date();
		Date fechaFin = prestamoActivo.getFechaFin();
		if (fechaActual.compareTo(fechaFin) > 0) {
		}

		_prestamoDAO.save(prestamoActivo);
	}

	public void realizarReserva(String aIdUsuario, String aIsbn) {
		throw new UnsupportedOperationException();
	}

	public Prestamo realizarPrestamo(Usuario usuario, Titulo titulo, Ejemplar ejemplar) {
		Prestamo p = Prestamo.prestamoDeDiasDesdeHoy(7, usuario, titulo, ejemplar);
		_prestamoDAO.save(p);
		return p;
	}
}