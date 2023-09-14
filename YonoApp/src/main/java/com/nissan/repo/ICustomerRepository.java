package com.nissan.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import com.nissan.model.Customer;

@Repository
public interface ICustomerRepository extends CrudRepository<Customer, Integer> {
	
	
	//already has the basic crud operations
	
	
	//search by name
	/*@Query("from Employee WHERE employeeName like %?1%")
	public List<Customer> findByCustomerName(String name);
	
	//inner join
	@Query("SELECT new com.nissan.dto.EmployeeDeptDto(e.id,e.employeeName,e.designation,d.departmentName) "
			+ "FROM Customer c INNER JOIN e.department d ORDER BY e.id")
	public List<EmployeeDeptDto> findAllDTOEmployees();*/
	
	
	/*@Query("Update new com.nissan.dto.CustomerDto(e.id,e.employeeName,e.designation,d.departmentName) "
			+ "FROM Customer c WHERE accountNumber like %?1%\")
	public Long showBalance(long accountNumber);*/
	
	@Modifying
	@Query("UPDATE com.nissan.model.Customer SET balance=balance+?2 WHERE accountNo like ?1")
	public void deposit(String accountNumber,long amount);
	
	
	@Query("SELECT balance FROM com.nissan.model.Customer  WHERE accountNo like ?1")
	public long showBalance(String accountNumber);
	
	@Modifying
	@Query("UPDATE com.nissan.model.Customer SET balance=balance-?2 WHERE accountNo like ?1")
	public void withdraw(String accountNumber,long amount);
	
	@Modifying
	@Query("UPDATE com.nissan.model.Customer SET balance=balance+?2 WHERE accountNo like ?1")
	public Long transferDeposit(String receiverAccountNumber,long amount);
	
	@Modifying
	@Query("UPDATE com.nissan.model.Customer SET balance=balance-?2 WHERE accountNo like ?1")
	public Long transferWithdraw(String senderAccountNumber,long amount);
}
