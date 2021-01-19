package org.acme;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.inject.Inject;

import org.acme.cliente.Autor;
import org.acme.interfaces.AutorService;
import org.acme.resources.AutorResource;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;

@QuarkusTest
public class AutorResourceTest {

	@InjectMock
	@RestClient
	AutorService Mockautorservice;

	@Inject
	AutorResource autorresource;

	@BeforeEach
	public void Preparacion() {

		List<Autor> lista = new ArrayList<>();
		Autor primero = new Autor(1, "pepito", "grillo", null);
		Autor segundo = new Autor(1, "Ramon", "Romero", null);
		Autor tercero = new Autor(1, "Pedro", "Sanchez", null);
		lista.add(primero);
		lista.add(segundo);
		lista.add(tercero);

		Mockito.when(Mockautorservice.listado()).thenReturn(lista);

	}

	@Test
	public void testlistado_unitario() {

		Autor autor = new Autor(1, "pepe", "clemente", null);
		Optional<Autor> a = Optional.of(autor);

		Mockito.when(Mockautorservice.listado_unitario(Mockito.anyInt())).thenReturn(a);

		Assertions.assertEquals(a, autorresource.listado_unitario(1));
	}

	@Test
	public void testListado() {

		Assertions.assertEquals("Romero", autorresource.listado().get(1).getApellidos());

	}

	/*
	 * @Test public void TestEliminarAutor() {
	 * 
	 * 
	 * Autor a = new Autor(10, "SinNombre", "SinApellido",null);
	 * 
	 * Mockito.when(Mockautorservice.listado_unitario(10)).thenReturn(null);
	 * Mockautorservice.eliminarAutor(a.getId());
	 * Assertions.assertEquals(Mockautorservice.listado_unitario(10), null);
	 * 
	 * }
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * @Test public void TestguardarAutor(){
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * }
	 * 
	 * @Test public void TestactualizarAutor() {
	 * 
	 * 
	 * 
	 * }
	 */

}
