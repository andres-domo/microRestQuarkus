package org.acme.resources;

import java.util.List;
//import java.util.Set;
//import java.util.concurrent.CompletionStage;
import java.util.Optional;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.acme.cliente.Libro;

import org.acme.interfaces.LibroService;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

//import org.jboss.resteasy.annotations.jaxrs.PathParam;

//import io.smallrye.mutiny.Uni;

//la direccion que pones en el navegador Http://localhost:8085/book
@Path("/book")
public class LibroResource {

	@Inject
	@RestClient
	LibroService libroService;

	// url: http://localhost:8085/book/listado
	@GET
	@Path("/listado")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Libro> listado() {

		return libroService.listado();
	}

	// url: http://localhost:8085/book/listado/id
	@GET
	@Path("/listado/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Optional<Libro> listado_unitario(@PathParam int id) {

		return libroService.listado_unitario(id);
	}

	// url: http://localhost:8085/book/eliminar/id
	@DELETE
	@Path("/eliminar/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public void eliminar(@PathParam("id") int id) {

		libroService.eliminarlibro(id);
	}

	// url: http://localhost:8085/book/guardar
	@POST
	@Path("/guardar")
	@Produces(MediaType.APPLICATION_JSON)
	public void guardar(Libro libro) {

		libroService.guardarlibro(libro);
	}

	// url: http://localhost:8085/book/actualizar
	@PUT
	@Path("/actualizar")
	@Produces(MediaType.APPLICATION_JSON)
	public void actualizar(Libro libro) {

		libroService.actualizarlibro(libro);
	}

}
