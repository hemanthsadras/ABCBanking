package com.abcbank.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abcbank.models.Customer;
import com.abcbank.repositories.CustomerRepository;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	public CustomerService(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}
	
	public Customer addCustomer(Customer customer) {
		Customer customerFromRepository = customerRepository.insert(customer);
		return customerFromRepository;
	}
	
	public void deleteCustomer(String customerId) {
		this.customerRepository.delete(customerId);
	}
	
	public Customer getCustomer(String customerId) {
		return this.customerRepository.findOne(customerId);
	}
	
	

}
