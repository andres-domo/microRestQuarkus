package org.acme;

import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.inject.Inject;

import org.acme.cliente.Autor;
import org.acme.cliente.Libro;
import org.acme.interfaces.LibroService;
import org.acme.resources.LibroResource;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;

@QuarkusTest
class LibroResourceTest {

	@InjectMock
	@RestClient
	LibroService Mocklibroservicio;

	@Inject
	LibroResource libroresource;
	// @TestHTTPEndpoint(LibroResource.class)//hace que el path sea /book.
	// @TestHTTPResource
	// URL url;

	@BeforeEach
	public void Preparacion() {

		List<Libro> lista = new ArrayList<>();
		Libro uno = new Libro(1, "Los jardines del Edén", 2343434, null);
		Libro dos = new Libro(1, "Las puertas del inframundo", 6535455, null);
		Libro tres = new Libro(1, "Cada cual Pascual", 64562333, null);
		lista.add(uno);
		lista.add(dos);
		lista.add(tres);

		Mockito.when(Mocklibroservicio.listado()).thenReturn(lista);

	}

	@Test
	public void testlistado() {

		Assertions.assertEquals("Las puertas del inframundo", libroresource.listado().get(1).getTitulo());

	}

	@Test
	public void testlistado_unitario() {

		Libro libro = new Libro(1, "las acacias del Kilimanjaro", 543425, null);
		Optional<Libro> a = Optional.of(libro);

		Mockito.when(Mocklibroservicio.listado_unitario(Mockito.anyInt())).thenReturn(a);

		Assertions.assertEquals(a, libroresource.listado_unitario(1));

	}

	@Test
	public void TestEliminarLibro() {

		Libro a = new Libro(10, "Narcisos en la noche", 4536535, null);

		Mockito.when(Mocklibroservicio.listado_unitario(10)).thenReturn(null);
		Mocklibroservicio.eliminarlibro(a.getId());
		Assertions.assertEquals(Mocklibroservicio.listado_unitario(10), null);

	}

	@Test
	public void TestguardarLibro() {

		Libro nuevo_libro = new Libro(1, "Campanas del Alba", 7858575, null);
		Optional<Libro> b = Optional.of(nuevo_libro);

		Mockito.when(Mocklibroservicio.listado_unitario(Mockito.anyInt())).thenReturn(b);
		Mocklibroservicio.guardarlibro(nuevo_libro);
		Assertions.assertNotEquals(b, null);
		Assertions.assertEquals(b, Mocklibroservicio.listado_unitario(1));

	}

	@Test
	public void TestactualizarLibro() {

		Libro uno = new Libro(1, "las triquiñuelas de Gaspar", 565857, null);

		uno.setId(2);
		uno.setIsbn(332211345);

		Mocklibroservicio.actualizarlibro(uno);

	}
}
