package com.abcbank.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abcbank.models.BankCounter;
import com.abcbank.models.BankService;
import com.abcbank.repositories.BankCounterRepository;

@Service
public class BankCounterService {
	
	@Autowired
	private BankCounterRepository bankCounterRepository;
	
	public BankCounterService(BankCounterRepository bankCounterRepository) {
		this.bankCounterRepository = bankCounterRepository;
	}
	
	public List<BankCounter> getAllBankCounters() {
		return this.bankCounterRepository.findAll();
	}
	
	public BankCounter getBankCounterById(String id) {
		return this.bankCounterRepository.findOne(id);
	}
	
	public BankCounter addBankCounter(BankCounter bankCounter) {
		return this.bankCounterRepository.insert(bankCounter);
	}
	
	public BankCounter updateBankCounter(BankCounter bankCounter) {
		return this.bankCounterRepository.save(bankCounter);
	}
	
	public List<BankCounter> getBankCounterByServiceType(BankService bankService) {
		return this.bankCounterRepository.findByBankService(bankService);
	}

}
