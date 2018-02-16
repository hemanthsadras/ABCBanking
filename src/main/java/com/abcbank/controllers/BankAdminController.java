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
import com.abcbank.services.BankAdminService;

@RestController
@RequestMapping("/admin")
public class BankAdminController {

	@Autowired
	private BankAdminService bankAdminService;
	
	public BankAdminController(BankAdminService bankAdminService) {
		this.bankAdminService = bankAdminService;
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
		return this.bankAdminService.addBankCounter(bankCounter);
	}
	
	@GetMapping("/bankCounter")
	public List<BankCounter> getAllBankCounters() {
		return this.bankAdminService.getAllBankCounters();
	}
	
	@PutMapping("/bankCounter")
	public BankCounter updateBankCounter(@RequestBody BankCounter bankCounter) {
		return this.bankAdminService.updateBankCounter(bankCounter);
	}
	
	@GetMapping("/bankCounter/{bankCounterId}")
	public BankCounter getBankCounter(@PathVariable String bankCounterId) {
		return this.bankAdminService.getBankCounter(bankCounterId);
	}
	
}
