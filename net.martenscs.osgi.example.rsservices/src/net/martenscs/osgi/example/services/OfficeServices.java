/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.martenscs.osgi.example.services;

import java.util.List;

import javax.ws.rs.Path;
import javax.ws.rs.core.GenericEntity;

import net.martenscs.osgi.example.domain.api.Office;

/**
 * 
 * @author cmartens
 */
@Path("/")
public class OfficeServices extends GenericRestService<Office, String> {

	@Override
	public String transformIdToPK(String id) {
		return id;
	}

	@Override
	public String getIdFromEntity(Office entity) {
		return entity.getOfficecode();
	}

	@Override
	public GenericEntity<List<Office>> getCastGenericEntity(List<Office> p) {
		return new GenericEntity<List<Office>>(p) {
		};
	}
}
