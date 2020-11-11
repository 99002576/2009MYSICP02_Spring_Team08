package com.bankapp.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "bank")
@TypeAlias("bank")
public class Bank {
	@Id
	Integer accNo;
	String name;
	Double balance;
	String accType;
	String phoneNo;
	public Integer getAccNo() {
		return accNo;
	}
	public void setAccNo(Integer accNo) {
		this.accNo = accNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	public String getAccType() {
		return accType;
	}
	public void setAccType(String accType) {
		this.accType = accType;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public Bank(Integer accNo, String name, Double balance, String accType, String phoneNo) {
		super();
		this.accNo = accNo;
		this.name = name;
		this.balance = balance;
		this.accType = accType;
		this.phoneNo = phoneNo;
	}
	public Bank() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Bank [accNo=" + accNo + ", name=" + name + ", balance=" + balance + ", accType=" + accType
				+ ", phoneNo=" + phoneNo + "]";
	}
	
	
}
