package com.bankapp.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

@RestController
@RequestMapping("/bank-api")
public class BankResponseController {

	@Autowired
	BankService bankService;
	
	 @PostMapping("/banks")
	    ResponseEntity<Bank> addBankAccount(@RequestBody Bank bank) {
	        Bank nbank = bankService.addBankAccount(bank);
	        return ResponseEntity.ok(nbank);
	 	}
	 
	 @DeleteMapping("/banks/delete-one/{accNo}")
	    ResponseEntity<Void> deleteBook(@PathVariable("accNo")Integer accNo) throws BankAccountNotFoundException{
	        bankService.deleteBankAccount(accNo);
	        return ResponseEntity.status(HttpStatus.OK).build();
	    }
	 
	 @GetMapping("/banks/get-one/{accNo}")
	    ResponseEntity<Bank> getBankAccountByAccNo(@PathVariable("accNo")Integer accNo) throws BankAccountNotFoundException{
	        Bank nbank = bankService.getBankAccountByAccNo(accNo);
	        HttpHeaders header = new HttpHeaders();
	        header.add("desc", "Getting bank account by Account Number");
	        header.add("name", "Aadya");
	        return ResponseEntity.status(HttpStatus.OK)
	                .headers(header).body(nbank);
	    }
	 
	 @PutMapping("/banks/update-one/{accNo}")
	    ResponseEntity<Bank> updateBankAccount(Bank bank) {
	        Bank nbank = bankService.updateBankAccount(bank);
	        HttpHeaders header = new HttpHeaders();
	        header.add("desc", "Updating bank Account");
	        header.add("name", "Aadya");
	        return ResponseEntity.status(HttpStatus.OK)
	                .headers(header).body(nbank);
	    }
	 
	 @GetMapping("/banks")
	    ResponseEntity<List<Bank>> getAllBankAccounts(){
	        List<Bank> bookList =  bankService.getAllBankAccounts();
	        return ResponseEntity.ok(bookList);
	    }
	 
	 @GetMapping("/banks/name/{name}")
	    ResponseEntity<List<Bank>> getBankAccountByName(@PathVariable("name")String name) throws BankAccountNotFoundException{
	        List<Bank> bankList =  bankService.getBankAccountByName(name);
	        return ResponseEntity.ok(bankList);
	    }
	 
	 
//	 @GetMapping("/books/acctypephone/{accType}/{phoneNo}")
//	    public ResponseEntity<List<Bank>> findBankAccountsByAcctypeAndPhone(@PathVariable("accType")String accType,
//	            @PathVariable("phoneNo")Integer phoneNo) {
//	        List<Bank> bankList = bankService.findAccountsByAcctypeAndPhone(accType, phoneNo);
//	        return ResponseEntity.ok(bankList);
//	        
//	    }
}
	 
