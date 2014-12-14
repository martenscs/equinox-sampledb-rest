/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.martenscs.osgi.example.services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import net.martenscs.osgi.example.domain.api.Payment;
import net.martenscs.osgi.example.domain.api.Repository;

/**
 * 
 * @author cmartens
 */
@SuppressWarnings("rawtypes")
@Path("/")
public class PaymentServices extends CustomerServices {


	private Repository paymentRepository;

	@Path("/{id}")
	@GET
	@Produces({ "application/json", "application/xml" })
	public Response get(@PathParam("id") String customerNumber,
			@PathParam("checkNumber") String checkNumber) {

		Payment p = (Payment) getRepository().get(
				transformIdToPK(customerNumber));
		if (p == null) {
			return Response.status(404).entity("Not found").build();
		} else {
			return Response.ok(p).build();
		}
	}

	public Repository getPaymentRepository() {
		return paymentRepository;
	}

	public void setPaymentRepository(Repository paymentRepository) {
		this.paymentRepository = paymentRepository;
	}
}
