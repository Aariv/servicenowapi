/**
 * 
 */
package com.shab.servicenow.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.shab.servicenow.utils.ServiceNowRestClient;

/**
 * @author zentere
 *
 */
@RestController
public class UsersResource {
	
	@Autowired
	private ServiceNowRestClient serviceNowRest;

	@GetMapping("/users")
	public JsonNode users() {
		return serviceNowRest.listUsers();
	}
	
}
