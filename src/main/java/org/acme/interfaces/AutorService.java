package org.acme.interfaces;

import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.acme.cliente.Autor;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

//los endpoints del microservicio al que llamas

@Path("/autor")
@RegisterRestClient
@ApplicationScoped
public interface AutorService {

	// url del micro al que quieres llamar http://localhost:8080/autor/listar
	@GET
	@Path("/listar")
	@Produces("application/json")
	List<Autor> listado();

	// url: http://localhost:8080/autor/listar/id
	@GET
	@Path("/listar/{id}")
	@Produces("application/json")
	Optional<Autor> listado_unitario(@PathParam int id);

	// url: http://localhost:8080/autor/eliminar/id
	@DELETE
	@Path("/eliminar/{id}")
	@Produces("application/json")
	void eliminarAutor(@PathParam int id);

	// url: http://localhost:8080/autor/guardar
	@POST
	@Path("/guardar")
	@Produces("application/json")
	void guardarAutor(Autor autor);

	// url: http://localhost:8080/autor/actualizar
	@PUT
	@Path("/actualizar")
	@Produces("application/json")
	void actualizarAutor(Autor autor);
}
