package com.abcbank.services;

import java.text.MessageFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abcbank.exceptions.BankCounterNotFoundException;
import com.abcbank.exceptions.Messages;
import com.abcbank.exceptions.TokenNotFoundException;
import com.abcbank.models.BankCounter;
import com.abcbank.models.BankService;
import com.abcbank.models.Token;
import com.abcbank.repositories.BankCounterRepository;
import com.abcbank.repositories.TokenRepository;

@Service
public class BankCounterService {
	
	@Autowired
	private BankCounterRepository bankCounterRepository;
	
	@Autowired
	private TokenRepository tokenRepository;
	
	public BankCounterService(BankCounterRepository bankCounterRepository) {
		this.bankCounterRepository = bankCounterRepository;
	}
	
	public List<BankCounter> getAllBankCounters() {
		List<BankCounter> bankCounters =  this.bankCounterRepository.findAll();
		if(bankCounters == null) {
			throw new BankCounterNotFoundException(Messages.NO_BANK_COUNTER_FOUND);
		}
		return bankCounters;
	}
	
	public BankCounter getBankCounterById(String id) {
		BankCounter bankCounter =  this.bankCounterRepository.findOne(id);
		if(bankCounter == null) {
			throw new BankCounterNotFoundException(MessageFormat.format(Messages.BANK_COUNTER_NOT_FOUND, id));
		}
		return bankCounter;
	}
	
	public BankCounter addBankCounter(BankCounter bankCounter) {
		return this.bankCounterRepository.insert(bankCounter);
	}
	
	public BankCounter updateBankCounter(BankCounter bankCounter) {
		return this.bankCounterRepository.save(bankCounter);
	}
	
	public List<BankCounter> getBankCountersByServiceType(BankService bankService) {
		List<BankCounter> bankCounters =  this.bankCounterRepository.findByBankService(bankService);
		if(bankCounters == null) {
			throw new BankCounterNotFoundException(MessageFormat.format(Messages.BANK_COUNTER_WITH_SERVICE_TYPE_NOT_FOUND, bankService.getBankServiceName()));
		}
		return bankCounters;
	}
	
	public Token getFirstTokenFromQueue(String bankCounterId) {
		BankCounter bankCounter = getBankCounterById(bankCounterId);
		Token token = bankCounter.getCustomerQueue().peek();
		if(token == null) {
			throw new TokenNotFoundException(MessageFormat.format(Messages.TOKEN_NOT_FOUND_IN_BANK_COUNTER, bankCounterId));
		}
		return token;
	}
	
	public void processToken(String bankCounterId, Token token) {
		BankCounter bankCounter = getBankCounterById(bankCounterId);
		bankCounter.getCustomerQueue().remove();
		this.bankCounterRepository.save(bankCounter);
		tokenRepository.insert(token);
	}

	public void deleteBankCounter(String bankCounterId) {
		try {
			this.bankCounterRepository.delete(bankCounterId);
		}
		catch(Exception e) {
			throw new BankCounterNotFoundException(MessageFormat.format(Messages.BANK_COUNTER_NOT_FOUND, bankCounterId));
		}
		
	}
	
	public void changeTokenCounter(String fromCounterId, String toCounterId, Token token) {
		BankCounter fromCounter = getBankCounterById(fromCounterId);
		BankCounter toCounter = getBankCounterById(toCounterId);
		toCounter.getCustomerQueue().add(token);
		this.bankCounterRepository.save(toCounter);
		fromCounter.getCustomerQueue().remove(token);
		this.bankCounterRepository.save(fromCounter);
	}

}
