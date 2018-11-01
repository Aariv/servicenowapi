package com.shab.servicenow;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.shab.servicenow.utils.ServiceNowRestClient;

@SpringBootApplication
public class ServiceNowApiApplication implements CommandLineRunner {
	
	@Autowired
	private ServiceNowRestClient serviceNowRestClient;

	public static void main(String[] args) {
		SpringApplication.run(ServiceNowApiApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Override
	public void run(String... args) throws Exception {
		serviceNowRestClient.sampleRest();
		
		//System.out.println(serviceNowRestClient.listUsers());
	}

}
