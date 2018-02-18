package com.abcbank.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abcbank.models.Customer;
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
	public List<Customer> getCustomer() {
		return this.customerService.getAllCustomers();
	}
	
	@GetMapping("/{customerId}")
	public Customer getCustomer(@PathVariable String customerId) {
		return this.customerService.getCustomer(customerId);
	}
	
	@GetMapping("/email/{emailId}/")
	public Customer getCustomerByEmailId(@PathVariable String emailId) {
		return this.customerService.getCustomerByEmailId(emailId);
	}

}
