package org.acme.cliente;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

public class Libro {

	private int id;

	private String titulo;

	private int isbn;

	private List<Autor> autores;

	public Libro(int id, String titulo, int isbn, List<Autor> autores) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.isbn = isbn;
		this.autores = autores;
	}

	public Libro() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getIsbn() {
		return isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

	public List<Autor> getAutores() {
		return autores;
	}

	public void setAutores(List<Autor> autores) {
		this.autores = autores;
	}

}
