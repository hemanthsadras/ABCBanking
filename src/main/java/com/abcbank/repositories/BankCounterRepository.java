package com.abcbank.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.abcbank.models.BankCounter;
import com.abcbank.models.BankService;

@Repository
public interface BankCounterRepository extends MongoRepository<BankCounter,String>{
	
	List<BankCounter> findByBankService(BankService bankService);

}
