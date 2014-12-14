package net.martenscs.osgi.example.services;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import net.martenscs.osgi.example.domain.api.Repository;

public interface RestService<Entity, PK> {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public abstract Response list();

	@Path("/{id}")
	@GET
	@Produces({ "application/json", "application/xml" })
	public abstract Response get(@PathParam("id") String id);

	@Path("/")
	@POST
	@Produces({ "application/json", "application/xml" })
	@Consumes({ "application/json", "application/xml" })
	public abstract Response create(Entity p);

	@Path("/{id}")
	@DELETE
	public abstract Response delete(@PathParam("id") String id);

	public abstract Repository<Entity, PK> getRepository();

	public abstract void setRepository(Repository<Entity, PK> repository);

}