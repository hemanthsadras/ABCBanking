package com.abcbank.services;

import java.text.MessageFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abcbank.exceptions.CustomerNotFoundException;
import com.abcbank.exceptions.Messages;
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
		try {
			this.customerRepository.delete(customerId);
		}
		catch(Exception ex) {
			throw new CustomerNotFoundException(MessageFormat.format(Messages.CUSTOMER_NOT_FOUND, customerId));
		}
	}
	
	public Customer getCustomer(String customerId) {
		Customer customer = this.customerRepository.findOne(customerId);
		if(customer == null) {
			throw new CustomerNotFoundException(MessageFormat.format(Messages.CUSTOMER_NOT_FOUND, customerId));
		}
		return customer;
	}

	public List<Customer> getAllCustomers ()
	{
		List<Customer> customers =  this.customerRepository.findAll();
		if(customers == null) {
			throw new CustomerNotFoundException(Messages.NO_CUSTOMERS_FOUND);
		}
		
		return customers;
	}
	
	public Customer getCustomerByEmailId(String emailId) {
		Customer customer = this.customerRepository.findByEmailId(emailId);
		if(customer == null) {
			throw new CustomerNotFoundException(MessageFormat.format(Messages.CUSTOMER_WITH_EMAILID_NOT_FOUND, emailId));
		}
		return customer;
	}
	
	

}
