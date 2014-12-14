/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.martenscs.osgi.example.services;

import java.util.List;

import javax.ws.rs.Path;
import javax.ws.rs.core.GenericEntity;

import net.martenscs.osgi.example.domain.api.Employee;

/**
 * 
 * @author cmartens
 */
@Path("/")
public class EmployeeServices extends GenericRestService<Employee, Integer> {

	@Override
	public Integer transformIdToPK(String id) {
		return Integer.parseInt(id);
	}

	@Override
	public String getIdFromEntity(Employee entity) {
		return String.valueOf(entity.getEmployeenumber());
	}

	@Override
	public GenericEntity<List<Employee>> getCastGenericEntity(List<Employee> p) {
		return new GenericEntity<List<Employee>>(p) {
		};
	}
}
