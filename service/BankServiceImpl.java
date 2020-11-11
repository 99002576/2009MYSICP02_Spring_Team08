package com.bankapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankapp.dao.BankRepository;
import com.bankapp.exception.BankAccountNotFoundException;
import com.bankapp.model.Bank;

@Service
public class BankServiceImpl implements BankService{

	@Autowired
	BankRepository bankRepository;
	
	
	public BankServiceImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public Bank addBankAccount(Bank bank) {
		Bank newBank = bankRepository.save(bank);
		return newBank;
	}

	@Override
	public boolean deleteBankAccount(Integer accNo) throws BankAccountNotFoundException {
		bankRepository.deleteById(accNo);
		return true;
	}

	@Override
	public Bank getBankAccountByAccNo(Integer accNo) throws BankAccountNotFoundException {
		return bankRepository.findById(accNo)
				.orElseThrow(()->new BankAccountNotFoundException("Account Number not available"));
	}

	@Override
	public Bank updateBankAccount(Bank bank) {
		return bankRepository.save(bank);
	}

	@Override
	public List<Bank> getAllBankAccounts() {
		return bankRepository.findAll();
	}

	@Override
	public List<Bank> getBankAccountByName(String name) throws BankAccountNotFoundException {
		List<Bank> bankList = bankRepository.findByName(name);
		if(bankList.isEmpty()) {
			throw new BankAccountNotFoundException ("Name not available");
		}
		return bankList;
	}

//	@Override
//	public List<Bank> findAccountsByAcctypeAndPhone(String accType, Integer phoneNo) {
//		return bankRepository.findByAccountTypeandPhone(accType, phoneNo);
//	}
	
	

}
