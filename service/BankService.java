package com.bankapp.service;

import java.util.List;

import com.bankapp.exception.BankAccountNotFoundException;
import com.bankapp.model.Bank;

public interface BankService {
	Bank addBankAccount(Bank bank);
	boolean deleteBankAccount(Integer accNo) throws BankAccountNotFoundException;
	Bank getBankAccountByAccNo(Integer accNo) throws BankAccountNotFoundException;
	Bank updateBankAccount(Bank bank);
	List<Bank> getAllBankAccounts();
	List<Bank> getBankAccountByName(String name) throws BankAccountNotFoundException;
	//List<Bank> findAccountsByAcctypeAndPhone(String accType, Integer phoneNo);
}
