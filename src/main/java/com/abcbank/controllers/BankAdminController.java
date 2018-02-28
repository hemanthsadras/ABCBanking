package com.abcbank.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abcbank.models.BankCounter;
import com.abcbank.models.BankService;
import com.abcbank.models.Token;
import com.abcbank.services.BankAdminService;
import com.abcbank.services.BankCounterService;

@RestController
@RequestMapping("/admin")
public class BankAdminController {

	@Autowired
	private BankAdminService bankAdminService;
	
	@Autowired
	private BankCounterService bankCounterService;
	
	public BankAdminController(BankAdminService bankAdminService, BankCounterService bankCounterService) {
		this.bankAdminService = bankAdminService;
		this.bankCounterService = bankCounterService;
	}
	
	@PostMapping("/bankService")
	public BankService addBankService(@RequestBody BankService bankService) {
		return this.bankAdminService.addBankService(bankService);
	}
	
	@DeleteMapping("/bankService/{bankServiceId}")
	public void deleteBankService(@PathVariable String bankServiceId) {
		this.bankAdminService.deleteBankService(bankServiceId);
	}
	
	@PutMapping("/bankService")
	public BankService updateBankService(@RequestBody BankService bankService) {
		return this.bankAdminService.updateBankService(bankService);
	}
	
	@GetMapping("/bankService/{bankServiceId")
	public BankService getBankService(String bankServiceId) {
		return this.bankAdminService.getBankService(bankServiceId);
	}
	
	@GetMapping("/bankService")
	public List<BankService> getAllBankServices() {
		return this.bankAdminService.getAllBankServices();
	}
	
	@PostMapping("/bankCounter")
	public BankCounter addBankCounter(@RequestBody BankCounter bankCounter) {
		return this.bankCounterService.addBankCounter(bankCounter);
	}
	
	@DeleteMapping("/bankCounter/{bankCounterId}")
	public void deleteBankCounter(@PathVariable String bankCounterId) {
		this.bankCounterService.deleteBankCounter(bankCounterId);
	}
	
	@GetMapping("/bankCounter")
	public List<BankCounter> getAllBankCounters() {
		return this.bankCounterService.getAllBankCounters();
	}
	
	@PutMapping("/bankCounter")
	public BankCounter updateBankCounter(@RequestBody BankCounter bankCounter) {
		return this.bankCounterService.updateBankCounter(bankCounter);
	}
	
	@GetMapping("/bankCounter/{bankCounterId}")
	public BankCounter getBankCounter(@PathVariable String bankCounterId) {
		return this.bankCounterService.getBankCounterById(bankCounterId);
	}
	
	@GetMapping("/bankCounter/{bankCounterId}/token")
	public Token getTokenFromQueue(@PathVariable String bankCounterId) {
		return this.bankCounterService.getFirstTokenFromQueue(bankCounterId);
	}
	
	@PutMapping("/bankCounter/{bankCounterId}/token")
	public void processToken(@PathVariable String bankCounterId, @RequestBody Token token) {
		this.bankCounterService.processToken(bankCounterId,token);
	}
	
	@PutMapping("/bankCounter/{fromCounterId}/token/{toCounterId}")
	public void delegateTokenToAnotherCounter(@PathVariable String fromCounterId, @PathVariable String toCounterId, @RequestBody Token token) {
		this.bankCounterService.changeTokenCounter(fromCounterId, toCounterId, token);
	}
	
}
