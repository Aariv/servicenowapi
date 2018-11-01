/**
 * 
 */
package com.shab.servicenow.utils;

import java.nio.charset.Charset;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;

/**
 * @author zentere
 *
 */
@Component
public class ServiceNowRestClient {

	@Autowired
	private RestTemplate restTemplate;

	public ServiceNowRestClient() {
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings("serial")
	HttpHeaders createHeaders(String username, String password) {
		return new HttpHeaders() {
			{
				String auth = username + ":" + password;
				byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));
				String authHeader = "Basic " + new String(encodedAuth);
				set("Authorization", authHeader);
			}
		};
	}
	
	public String sampleRest() {
		String uri = "https://sysusademo4.service-now.com/api/now/stats/incident?sysparm_avg_fields=reassignment_count%2Cbusiness_stc&sysparm_group_by=assignment_group";
		ResponseEntity<String> output = restTemplate.exchange(uri, HttpMethod.GET, new HttpEntity<String>(createHeaders("shabnam.memon", "shab#786")), String.class);
		return output.getBody();
	}
	
	public JsonNode listUsers() {
		String uri = "https://sysusademo4.service-now.com/api/now/table/sys_user";
		ResponseEntity<JsonNode> output = restTemplate.exchange(uri, HttpMethod.GET, new HttpEntity<String>(createHeaders("shabnam.memon", "shab#786")), JsonNode.class);
		return output.getBody();
	}
	
}
