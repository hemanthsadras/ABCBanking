package com.abcbank.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abcbank.models.Customer;
import com.abcbank.models.CustomerType;
import com.abcbank.services.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}
	
	@PostMapping
	public Customer registerCustomer(@RequestBody Customer customer) {
		return customerService.addCustomer(customer);
	}
	
	@GetMapping
	public Customer getCustomer() {
		Customer customer = new Customer();
		customer.setName("hemanth");
		customer.setEmailId("hemanthsadras@gmail.com");
		customer.setId("89079");
		customer.setCustomerType(CustomerType.PREMIUM);
		List<String> bankServices = new ArrayList<>();
		bankServices.add("123");
		bankServices.add("234");
		customer.setBankServices(bankServices);
		return customer;
	}
	
	@GetMapping("/{customerId}")
	public Customer getCustomer(@PathVariable String customerId) {
		return this.customerService.getCustomer(customerId);
	}

}
