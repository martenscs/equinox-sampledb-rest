package net.martenscs.osgi.example.services;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import net.martenscs.osgi.example.domain.api.Repository;

public abstract class GenericRestService<Entity, PK> implements
		RestService<Entity, PK> {

	private static final Logger logger = Logger
			.getLogger(GenericRestService.class.getName());
	
	
	private Repository<Entity, PK> repository;

	public abstract PK transformIdToPK(String id);

	public abstract String getIdFromEntity(Entity entity);

	public abstract GenericEntity<List<Entity>> getCastGenericEntity(
			List<Entity> p);

	@Override
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response list() {
		try {
			List<Entity> p = (getRepository().getAll());
			return Response.ok(getCastGenericEntity(p)).build();
		} catch (Exception ex) {
			logger.log(Level.SEVERE, "list", ex);
			return Response.status(500).entity(ex.toString()).build();
		}
	}

	@Override
	@Path("/{id}")
	@GET
	@Produces({ "application/json", "application/xml" })
	public Response get(@PathParam("id") String id) {

		Entity p = (Entity) getRepository().get(transformIdToPK(id));
		if (p == null) {
			return Response.status(404).entity("Not found").build();
		} else {
			return Response.ok(p).build();
		}
	}

	@Override
	@Path("/")
	@POST
	@Produces({ "application/json", "application/xml" })
	@Consumes({ "application/json", "application/xml" })
	public Response create(Entity p) {
		getRepository().add(p);
		return get(getIdFromEntity(p));
	}

	@Override
	@Path("/{id}")
	@DELETE
	public Response delete(@PathParam("id") String id) {
		try {
			getRepository().delete(transformIdToPK(id));
			return Response.ok().build();
		} catch (Exception ex) {
			return Response.serverError().entity(ex).build();
		}
	}

	@Override
	public Repository<Entity, PK> getRepository() {
		return repository;
	}

	@Override
	public void setRepository(Repository<Entity, PK> repository) {
		this.repository = repository;
	}
}
