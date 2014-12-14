/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.martenscs.osgi.example.services;

import java.util.List;

import javax.ws.rs.Path;
import javax.ws.rs.core.GenericEntity;

import net.martenscs.osgi.example.domain.api.Order;

/**
 * 
 * @author cmartens
 */
@Path("/")
public class OrderServices extends GenericRestService<Order, Integer> {

	@Override
	public Integer transformIdToPK(String id) {
		return Integer.parseInt(id);
	}

	@Override
	public String getIdFromEntity(Order entity) {
		return String.valueOf(entity.getOrdernumber());
	}

	@Override
	public GenericEntity<List<Order>> getCastGenericEntity(List<Order> p) {
		return new GenericEntity<List<Order>>(p) {
		};
	}
}
