package org.acme.resources;

import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.acme.cliente.Autor;
import org.acme.interfaces.AutorService;

import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

//los endopoints que pones en el puerto quarkus

@Path("/authors")
@ApplicationScoped
public class AutorResource {

	@Inject
	@RestClient
	AutorService autorService;

	// url: http://localhost:8085/authors/listado
	@GET
	@Path("/listado")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Autor> listado() {

		return autorService.listado();
	}

	// url: http://localhost:8085/authors/listado/id
	@GET
	@Path("/listado/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Optional<Autor> listado_unitario(@PathParam int id) {

		return autorService.listado_unitario(id);
	}

	// url: http://localhost:8085/authors/eliminar/id
	@DELETE
	@Path("/eliminar/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public void eliminar(@PathParam("id") int id) {

		autorService.eliminarAutor(id);
	}

	// url: http://localhost:8085/authors/guardar
	@POST
	@Path("/guardar")
	@Produces(MediaType.APPLICATION_JSON)
	public void guardar(Autor autor) {

		autorService.guardarAutor(autor);
	}

	// url: http://localhost:8085/authors/actualizar
	@PUT
	@Path("/actualizar")
	@Produces(MediaType.APPLICATION_JSON)
	public void actualizar(Autor autor) {
		autorService.actualizarAutor(autor);
	}
}