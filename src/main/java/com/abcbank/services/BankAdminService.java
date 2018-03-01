package com.abcbank.services;

import java.text.MessageFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abcbank.exceptions.BankServiceNotFoundException;
import com.abcbank.exceptions.Messages;
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
		try {
			this.bankServiceRepository.delete(id);
		}
		catch(Exception ex) {
			throw new BankServiceNotFoundException(MessageFormat.format(Messages.BANK_SERVICE_NOT_FOUND, id));
		}
	}
	
	public BankService updateBankService(BankService bankService) {
		return this.bankServiceRepository.save(bankService);
	}
	
	public BankService getBankService(String id) {
		BankService bankService = this.bankServiceRepository.findOne(id);
		if(bankService == null) {
			throw new BankServiceNotFoundException(MessageFormat.format(Messages.BANK_SERVICE_NOT_FOUND	, id));
		}
		
		return bankService;
	}
	
	public List<BankService> getAllBankServices() {
		List<BankService> bankServices =  this.bankServiceRepository.findAll();
		if(bankServices == null) {
			throw new BankServiceNotFoundException(Messages.NO_BANK_SERVICES_FOUND);
		}
		return bankServices;
	}
}
