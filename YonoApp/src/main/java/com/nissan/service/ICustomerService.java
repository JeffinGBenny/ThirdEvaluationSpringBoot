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
	
	public void showBalance(String accountNumber);

	void deposit(long accountNumber, long amount);

	void withdraw(long accountNumber, long amount);

}
