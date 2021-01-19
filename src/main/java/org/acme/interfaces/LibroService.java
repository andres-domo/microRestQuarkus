package org.acme.interfaces;

import java.util.List;
//import java.util.Set;
//import java.util.concurrent.CompletionStage;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.acme.cliente.Libro;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import org.jboss.resteasy.annotations.jaxrs.PathParam;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.jboss.resteasy.annotations.jaxrs.PathParam;

//import io.smallrye.mutiny.Uni;

@Path("/libros")
@RegisterRestClient
@ApplicationScoped
public interface LibroService {

	// url del micro al que quieres llamar http://localhost:8080/libros/listar
	@GET
	@Path("/listar")
	@Produces("application/json")
	List<Libro> listado();

	// url: http://localhost:8080/libros/listar/id
	@GET
	@Path("/listar/{id}")
	@Produces("application/json")
	Optional<Libro> listado_unitario(@PathParam int id);

	// url: http://localhost:8080/libros/eliminar/id
	@DELETE
	@Path("/eliminar/{id}")
	@Produces("application/json")
	void eliminarlibro(@PathParam int id);

	// url: http://localhost:8080/libros/guardar
	@POST
	@Path("/guardar")
	@Produces("application/json")
	void guardarlibro(Libro libro);

	// url: http://localhost:8080/libros/actualizar
	@PUT
	@Path("/actualizar")
	@Produces("application/json")
	void actualizarlibro(Libro libro);

}
