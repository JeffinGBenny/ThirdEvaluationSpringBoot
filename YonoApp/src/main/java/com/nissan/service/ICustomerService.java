package com.nissan.service;

import java.util.List;


import com.nissan.model.Customer;

public interface ICustomerService {

	// list
	/*public List<Customer> getCustomer();

	// insert
	public Customer saveCustomer(Customer customer);

	// update by id
	public Customer getCustomer(int id);

	// delete
	public void deleteCustomer(int id);

	

	// search by name
	//public List<Customer> getCustomerByName(String name);

	// inner join list
	//public List<EmployeeDeptDto> getAllDtoEmployees();*/
	
	public long showBalance(String accountNumber);

	void deposit(String accountNumber, long amount);

	void withdraw(String accountNumber, long amount);

	void transferWithdraw(String accountNumber, long amount);

	void transferDeposit(String accountNumber, long amount);

}
