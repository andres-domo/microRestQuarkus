package org.acme;



import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.google.inject.Inject;


import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

import java.util.List;
import java.util.UUID;

import org.acme.cliente.Libro;
import org.acme.interfaces.LibroService;
import org.acme.resources.LibroResource;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import io.quarkus.test.common.http.TestHTTPEndpoint;


//import org.acme.interfaces.LibroService;

import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;
//import io.quarkus.test.junit.mockito.InjectSpy;
import io.restassured.http.ContentType;

@QuarkusTest
class LibroResourceTest {

	@InjectMock
	@RestClient
	LibroService servicio;
	
	@Inject
	LibroResource libroresource;
	@TestHTTPEndpoint(LibroResource.class)//hace que el path sea /book.
	//@TestHTTPResource
	//URL url;
	
	
	 @Test
	 public void  testlistado() {
		 given().contentType(ContentType.JSON)
         	.when().get("/listado")
         	.then()
         		.statusCode(200)    
         		.body(is("[]"));
		 
	 }

	 @Test
	 public void testlistado_unitario() {
		 
		Libro libro= new Libro(1,"los pajaros del avismo",45543242,null) ;
		 
		servicio.guardarlibro(libro);
		
		 
		 given().contentType(ContentType.JSON)
      		.when().get("/listado/1")
      		.then()
      			.statusCode(200)    
      			.body(is(libro));
         		
	 }
	 
	/* @Test
	 public void testGuardar() {
		 
		 Libro libro2= new Libro(2,"los pajaros del averno",45543272,null) ;
		 
		servicio.guardarlibro(libro2);
		 
		  given().contentType(ContentType.JSON)
         	.when().get("/guardar")
         	.then()
         		.statusCode(200)    
         		.body(is(libro2));
		 
	 }*/
	/* @Test
	    public void testActualizar() {
		 given().contentType(ContentType.JSON)
      		.when().get("/actualizar")
      		.then()
      			.statusCode(200)    
      			.body(is("[]"));
	    }	*/
	 
}
