/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.martenscs.osgi.example.services;

import java.util.List;

import javax.ws.rs.Path;
import javax.ws.rs.core.GenericEntity;

import net.martenscs.osgi.example.domain.api.Customer;

/**
 * 
 * @author cmartens
 */
@Path("/")
public class CustomerServices extends GenericRestService<Customer, Integer> {

	
	
	
	@Override
	public Integer transformIdToPK(String id) {
		return Integer.parseInt(id);
	}

	@Override
	public String getIdFromEntity(Customer entity) {
		return String.valueOf(entity.getCustomernumber());
	}

	@Override
	public GenericEntity<List<Customer>> getCastGenericEntity(List<Customer> p) {
		return new GenericEntity<List<Customer>>(p) {
		};
	}

}
