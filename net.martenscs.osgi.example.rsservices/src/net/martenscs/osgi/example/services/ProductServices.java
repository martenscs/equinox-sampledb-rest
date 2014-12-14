/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.martenscs.osgi.example.services;

import java.util.List;

import javax.ws.rs.Path;
import javax.ws.rs.core.GenericEntity;

import net.martenscs.osgi.example.domain.api.Product;

/**
 * 
 * @author cmartens
 */
@Path("/")
public class ProductServices extends GenericRestService<Product, String> {

	@Override
	public String transformIdToPK(String id) {
		return id;
	}

	@Override
	public String getIdFromEntity(Product entity) {
		return entity.getProductcode();
	}

	@Override
	public GenericEntity<List<Product>> getCastGenericEntity(List<Product> p) {
		return new GenericEntity<List<Product>>(p) {
		};
	}
}
