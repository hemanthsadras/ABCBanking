package com.abcbank.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abcbank.models.BankCounter;
import com.abcbank.models.BankService;
import com.abcbank.repositories.BankCounterRepository;
import com.abcbank.repositories.BankServiceRepository;

@Service
public class BankAdminService {

	@Autowired
	private BankServiceRepository bankServiceRepository;
	
	@Autowired
	private BankCounterRepository bankCounterRepository;
	
	public BankAdminService(BankServiceRepository bankServiceRepository, BankCounterRepository bankCounterRepository) {
		this.bankServiceRepository = bankServiceRepository;
		this.bankCounterRepository = bankCounterRepository;
	}
	
	public BankService addBankService(BankService bankService) {
		return this.bankServiceRepository.insert(bankService);
	}
	
	public void deleteBankService(String id) {
		this.bankServiceRepository.delete(id);
	}
	
	public BankService updateBankService(BankService bankService) {
		return this.bankServiceRepository.save(bankService);
	}
	
	public BankService getBankService(String id) {
		return this.bankServiceRepository.findOne(id);
	}
	
	public List<BankService> getAllBankServices() {
		return this.bankServiceRepository.findAll();
	}
	
	public BankCounter addBankCounter(BankCounter bankCounter) {
		return this.bankCounterRepository.insert(bankCounter);
	}
	
	public BankCounter getBankCounter(String bankCounterId) {
		return this.bankCounterRepository.findOne(bankCounterId);
	}
	
	public void deleteBankCounter(String bankCounterId) {
		this.bankCounterRepository.delete(bankCounterId);
	}
	
	public BankCounter updateBankCounter(BankCounter bankCounter) {
		return this.bankCounterRepository.save(bankCounter);
	}
	
	public List<BankCounter> getAllBankCounters() {
		return this.bankCounterRepository.findAll();
	}
	
	public List<BankCounter> getBankCountersByServiceType(BankService bankService) {
		return this.bankCounterRepository.findByBankService(bankService);
	}
}
