package com.abcbank.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	
	@DeleteMapping("/bankService")
	public void deleteBankService(String bankServiceId) {
		this.bankAdminService.deleteBankService(bankServiceId);
	}
	
	@GetMapping("/bankService/{bankServiceId")
	public BankService getBankService(String bankServiceId) {
		return this.bankAdminService.getBankService(bankServiceId);
	}
	
	@GetMapping("/bankService")
	public List<BankService> getAllBankServices() {
		return this.bankAdminService.getAllBankServices();
	}
}
