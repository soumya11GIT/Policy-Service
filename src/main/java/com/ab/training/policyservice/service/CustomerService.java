package com.ab.training.policyservice.service;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ab.training.policyservice.model.Customer;

@Service
public class CustomerService {

	public Customer getCustomerDetails(String customerId) {
		// TODO Auto-generated method stub
		RestTemplate restTemplate = new RestTemplate();
	    ResponseEntity<Customer> response= restTemplate.getForEntity("http://localhost:8081/mongoCustomer/" +customerId, Customer.class);
		Customer customer= response.getBody();
		return customer;
		
	}
	
	public Customer getCustomerDetailsObject(String customerId) {
		RestTemplate restTemplate = new RestTemplate();
		Customer customer= restTemplate.getForObject("http://localhost:8081/mongoCustomer/" +customerId, Customer.class);
		return customer;
	}
	
	public Customer getCustomerDetailsExchange(String customerId) {
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<String>("", headers);
		ResponseEntity<Customer> response = restTemplate.exchange("http://localhost:8081/mongoCustomer/{customerId}", 
			                          HttpMethod.GET, entity, Customer.class, customerId);
		Customer customer = response.getBody();
		return customer;
	}

}
