package com.nissan.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nissan.common.Validation;

import com.nissan.model.Customer;
import com.nissan.repo.ICustomerRepository;


@Service
public class CustomerServiceImplementation implements ICustomerService {

	@Autowired
	private ICustomerRepository customerRepo;
	/*
	@Autowired
	private Validation validation;
	
	@Override
	public List<Customer> getCustomer() {
		return (List<Customer>) customerRepo.findAll();
	}

	@Override
	public Customer saveCustomer(Customer customer) {
		if (validation.isNameValid(customer.getCustomerName())) {
			return customerRepo.save(customer);
		}
		return null;
	}

	@Override
	public Customer getCustomer(int id) {
		// TODO Auto-generated method stub
		return customerRepo.findById(id).orElseThrow(() -> new RuntimeException("Customer Not Found with id: " + id));
	}

	@Override
	public void deleteCustomer(int id) {
		// TODO Auto-generated method stub

	}*/
	
	@Transactional
	@Override
	public long showBalance(String accountNumber) {
		// TODO Auto-generated method stub
		 return customerRepo.showBalance(accountNumber);
	}
	
	@Transactional
	@Override
	public void deposit(String accountNumber,long amount) {
		// TODO Auto-generated method stub
		 customerRepo.deposit(accountNumber,amount);
	}
	
	@Transactional
	@Override
	public void withdraw(String accountNumber,long amount) {
		// TODO Auto-generated method stub
		 customerRepo.withdraw(accountNumber,amount);
	}
	
	@Transactional
	@Override
	public void transferWithdraw(String accountNumber,long amount) {
		// TODO Auto-generated method stub
		 customerRepo.withdraw(accountNumber,amount);
	}
	
	@Transactional
	@Override
	public void transferDeposit(String accountNumber,long amount) {
		// TODO Auto-generated method stub
		 customerRepo.withdraw(accountNumber,amount);
	}

}
