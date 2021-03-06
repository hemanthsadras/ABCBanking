package com.abcbank.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.abcbank.models.Customer;

@Repository
public interface CustomerRepository extends MongoRepository<Customer,String> {

	Customer findByEmailId(String emailId);
}
