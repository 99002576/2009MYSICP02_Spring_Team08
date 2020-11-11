package com.bankapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bankapp.exception.BankAccountNotFoundException;
import com.bankapp.model.Bank;
import com.bankapp.service.BankService;

@Repository
//@RestController
//@RequestMapping("/bank-api")
public class BankController {
	@Autowired
	BankService bankService;
	
	@PostMapping("/banks")
	Bank addBankAccount(@RequestBody Bank bank) {
		return bankService.addBankAccount(bank);
	}
	
	@DeleteMapping("/banks/delete-one/{accNo}")
	boolean deleteBankAccount(@PathVariable("accNo")Integer accNo) throws BankAccountNotFoundException {
		return bankService.deleteBankAccount(accNo);
	}
	

	@GetMapping("/banks/get-one/{accNo}")
	Bank getBankAccountByAccNo(@PathVariable("accNo")Integer accNo) throws BankAccountNotFoundException{
		return bankService.getBankAccountByAccNo(accNo);
	}
	
	
	@PutMapping("/banks/update-one")
	Bank updateBankAccount(Bank bank) {
		return bankService.updateBankAccount(bank);
	}
	
	@GetMapping("/banks")
	List <Bank> getAllBankAccounts() {
		return bankService.getAllBankAccounts();
	}
	
	@GetMapping("/banks/name/{name}")
	List<Bank> getBankAccountByName(@PathVariable("name")String name) throws BankAccountNotFoundException{
		return bankService.getBankAccountByName(name);
	}
	
//	@GetMapping("/banks/acctypephone/{accType}/{phoneNo}")
//	public List<Bank> findBankAccountsByAcctypeAndPhone(@PathVariable("accType")String accType,@PathVariable("phoneNo")Integer phoneNo) throws BankAccountNotFoundException{
//		return bankService.findAccountsByAcctypeAndPhone(accType, phoneNo);
//	}
	
}
