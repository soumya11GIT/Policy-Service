package com.ab.training.policyservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ab.training.policyservice.model.Customer;
import com.ab.training.policyservice.model.Policy;
import com.ab.training.policyservice.repository.PolicyRepository;

@Service
public class PolicyService {
	
	@Autowired
	CustomerService customerService;
	
	@Autowired
	PolicyRepository policyRepository;
	
	public Policy createPolicy(Policy policy) {
		// TODO Auto-generated method stub
		Customer customer;
		customer= customerService.getCustomerDetails(policy.getCustomerDetails().getCustomerId());
		policy.setCustomerDetails(customer);
		return policyRepository.save(policy);
	}

	public List<Policy> getPolicies() {
		
		return policyRepository.findAll();
		
	}

}
