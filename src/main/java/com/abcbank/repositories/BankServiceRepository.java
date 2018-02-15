package com.abcbank.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.abcbank.models.BankService;

@Repository
public interface BankServiceRepository extends MongoRepository<BankService, String> {

}
