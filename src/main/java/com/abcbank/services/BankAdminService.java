package com.abcbank.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abcbank.models.BankService;
import com.abcbank.repositories.BankServiceRepository;

@Service
public class BankAdminService {

	@Autowired
	private BankServiceRepository bankServiceRepository;
	
	public BankAdminService(BankServiceRepository bankServiceRepository) {
		this.bankServiceRepository = bankServiceRepository;
	}
	
	public BankService addBankService(BankService bankService) {
		return this.bankServiceRepository.insert(bankService);
	}
	
	public void deleteBankService(String id) {
		this.bankServiceRepository.delete(id);
	}
	
	public BankService getBankService(String id) {
		return this.bankServiceRepository.findOne(id);
	}
	
	public List<BankService> getAllBankServices() {
		return this.bankServiceRepository.findAll();
	}
}
