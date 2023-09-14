package com.nissan.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import com.nissan.common.Validation;

import com.nissan.model.Customer;
import com.nissan.repo.IAdminRepository;
import com.nissan.repo.ICustomerRepository;


@Service
public class AdminServiceImplementation implements IAdminService {

	@Autowired
	private IAdminRepository adminRepo;
	
	@Autowired
	private Validation validation;
	
	@Override
	public List<Customer> getCustomer() {
		return (List<Customer>) adminRepo.findAll();
	}

	@Override
	public Customer saveCustomer(Customer customer) {
		if (validation.isNameValid(customer.getCustomerName())) {
			return adminRepo.save(customer);
		}
		return null;
	}

	@Override
	public Customer getCustomer(String id) {
		// TODO Auto-generated method stub
		return adminRepo.findById(id).orElseThrow(() -> new RuntimeException("Customer Not Found with id: " + id));
	}

	@Transactional
	@Override
	public void deleteCustomer(int accountNumber) {
		adminRepo.deleteCustomer(Integer.toString(accountNumber));

	}

}
