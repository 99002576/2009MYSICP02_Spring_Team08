package com.bankapp.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.bankapp.model.Bank;

@Repository
public interface BankRepository extends MongoRepository<Bank, Integer>{
	List<Bank> findByName(String name);
	//List<Bank> findByAccountTypeandPhone(String accType, Integer phoneNo);
}
