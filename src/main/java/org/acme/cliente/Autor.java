package org.acme.cliente;

import com.fasterxml.jackson.annotation.JsonIgnoreType;

//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreType(value = true)
public class Autor {

	private int id;

	private String nombre;

	private String apellidos;
	
	// @JsonIgnore
	private Libro libro;

	public Autor(int id, String nombre, String apellidos, Libro libro) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.libro = libro;
	}

	public Autor() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public Libro getIdLibro() {
		return libro;
	}

	// @JsonIgnore
	public void setIdLibro(Libro libro) {
		this.libro = libro;
	}

}
