package org.acme;


import org.junit.jupiter.api.Test;

import com.google.inject.Inject;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

import java.net.URL;

import org.acme.interfaces.LibroService;
import org.acme.resources.LibroResource;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import io.quarkus.test.Mock;
import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.common.http.TestHTTPResource;

//import org.acme.interfaces.LibroService;

import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;
//import io.quarkus.test.junit.mockito.InjectSpy;
import io.restassured.http.ContentType;

@QuarkusTest
class LibroResourceTest {

	
	@TestHTTPEndpoint(LibroResource.class)
	@TestHTTPResource
	URL url;
	
	 @Test
	 public void testListado() {
		 given().contentType(ContentType.JSON)
         	.when().get("/book/listado")
         	.then()
         		.statusCode(200)    
         		.body(is("[]"));
		 
	 }

	 @Test
	 public void testListado_unitario() {
		 given().contentType(ContentType.JSON)
         	.when().get("/book/listado/{id}")
         	.then()
         		.statusCode(200)    
         		.body(is("null"));
		 
	 }
	 
	 
}
