package es.uclm.library.business.entity;

import java.util.Vector;
import es.uclm.library.business.entity.Titulo;

public class Autor {
	private String _nombre;
	private String _apellido;
	public Vector<Titulo> _titulos = new Vector<Titulo>();
}