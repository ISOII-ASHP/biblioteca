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

	@PostMapping("/nuevo-prestamo")
	public String postNuevoPrestamo(
		@RequestParam Long usuario, 
		@RequestParam Long titulo, 
		Model model) {
		// Obtener el título por su ID
		Optional<Titulo> tOptional = _tituloDAO.findById(titulo);
		Titulo t = tOptional.get();

		// Obtener el usuario por su ID
		Optional<Usuario> uOptional = _usuarioDAO.findById(usuario);
		Usuario u = uOptional.get();

		ArrayList<String> errores = new ArrayList();

		// FIXME: establecer ese 4 de alguna propiedad MAX_PRESTAMOS
		// de alguna constante, algún fichero de config, vars. de entorno...
		if ( u.getPrestamos().size() >= 4 ) {
			errores.add("Usuario supera el límite de préstamos (4)");
		// TODO: comparar esta fecha con el día de hoy.
		} else if ( u.getFechaFinPenalizacion() != null ) {
			errores.add("Usuario penalizado. No se le puede prestar más hasta: " + 
							u.getFechaFinPenalizacion());
		}

		List<Ejemplar> ejemplares = _ejemplarDAO.findEjemplaresDisponibles(t);
		System.out.println(ejemplares);
		if ( ejemplares.size() == 0 ) {
			errores.add("No hay ejemplares disponibles");
		}


		if (errores.size() > 0) {
			List<Titulo> todosLosTitulos = _tituloDAO.findAll();
			List<Usuario> todosLosUsuarios = _usuarioDAO.findAll();
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
	public String realizarPrestamo(
		@RequestParam Long usuario, 
		@RequestParam Long titulo,
		@RequestParam Long ejemplar) {
		// Obtener el título por su ID
		Optional<Titulo> tOptional = _tituloDAO.findById(titulo);
		Titulo t = tOptional.get();

		// Obtener el usuario por su ID
		Optional<Usuario> uOptional = _usuarioDAO.findById(usuario);
		Usuario u = uOptional.get();

		// Obtener el ejemplar por su ID
		Optional<Ejemplar> eOptional = _ejemplarDAO.findById(ejemplar);
		Ejemplar e = eOptional.get();
		
		// Obtener fechas de inicio y de fin
		Date fechaInicio = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fechaInicio);
        calendar.add(Calendar.DAY_OF_YEAR, 7);
        Date fechaFin = calendar.getTime();

		Prestamo p = new Prestamo(fechaInicio, fechaFin, true, u, t, e);
		_prestamoDAO.save(p);

		return "confirmacion-prestamo";
	}


	@GetMapping("/devolucion")
	public String vistaDevolucion() {
		
		return "devolucion";
	}

	@PostMapping("/devolucion")
	public String realizarDevolucion(@RequestParam Long id, Model model) {
		Optional<Ejemplar> ejemplar = _ejemplarDAO.findById(id);

		ArrayList<String> errores = new ArrayList();

		if (ejemplar.isPresent()) {		
			// TODO: partir todo esto con otros métodos de cara a testear
			Prestamo prestamoActivo = 
					_prestamoDAO.findPrestamoActivoPorEjemplar(ejemplar.get());

			prestamoActivo.setActivo(false);
			
			// TODO: si fecha actual > fecha limite de devolucion, penalizar
			Date fechaActual = new Date();
			Date fechaFin = prestamoActivo.getFechaFin();
			if (fechaActual.compareTo(fechaFin) > 0) {
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(fechaFin);
				calendar.add(Calendar.DAY_OF_YEAR, 30);
				Date fechaPenalizacion = calendar.getTime();
				prestamoActivo.usuario.setFechaFinPenalizacion(fechaPenalizacion);
				_usuarioDAO.save(prestamoActivo.usuario);
			}

			_prestamoDAO.save(prestamoActivo);
			System.out.println(prestamoActivo);
		} else {
			errores.add("No se encontró ejemplar con ID " + id);
		}

		model.addAttribute("errores", errores);
		return "devolucion";
	}

	public void realizarReserva(String aIdUsuario, String aIsbn) {
		throw new UnsupportedOperationException();
	}
}