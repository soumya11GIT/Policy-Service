package com.ab.training.policyservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.ab.training.policyservice.model.Policy;
import com.ab.training.policyservice.service.PolicyService;

@RestController
public class PolicyController {
	
	@Autowired
	PolicyService policyService;
	
	@RequestMapping(value="/hello")
	public String hello() {
		return "hey there";
	}

	@RequestMapping(value="/policy", method = RequestMethod.POST)
   public Policy createPolicy(@RequestBody Policy policy) {
	return policyService.createPolicy(policy);
	}
	
	@RequestMapping(value="/policies", method = RequestMethod.GET)
	public List<Policy> getpolicies(){
		return policyService.getPolicies();
	}
}
