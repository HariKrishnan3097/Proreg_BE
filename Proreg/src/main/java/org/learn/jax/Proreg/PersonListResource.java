package org.learn.jax.Proreg;

import java.sql.SQLException;
import java.util.List;

import org.learn.jax.Proreg.model.Person;
import org.learn.jax.Proreg.service.PersonService;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@Path("/persons")
public class PersonListResource {

	PersonService ps = new PersonService();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getPerson() throws SQLException {
		return Response.ok(ps.getAllPerson(), MediaType.APPLICATION_JSON).build();
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)

	public Response addPerson(Person p) {
		return Response.status(Status.CREATED).entity(ps.insertPerson(p)).build();
	}

	@DELETE
	@Path("/{personID}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deletePerson(@PathParam("personID") String id) {
		return Response.ok(ps.deletePerson(id)).build();
	}

	@GET
	@Path("/{personID}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getPersonById(@PathParam("personID") String id) throws SQLException {
		return Response.ok(ps.getPersonById(id)).build();
	}

}
