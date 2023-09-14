package com.nissan.repo;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nissan.model.Customer;

@Repository
public interface IAdminRepository extends CrudRepository<Customer, String> {
	@Modifying
	@Query("UPDATE com.nissan.model.Customer SET isActive=0 WHERE accountNo like ?1")
	public void deleteCustomer(String accountNumber);
	//already has the basic crud operations
	
	//search by name
	/*@Query("from Employee WHERE employeeName like %?1%")
	public List<Customer> findByCustomerName(String name);
	
	//inner join
	@Query("SELECT new com.nissan.dto.EmployeeDeptDto(e.id,e.employeeName,e.designation,d.departmentName) "
			+ "FROM Employee e INNER JOIN e.department d ORDER BY e.id")
	public List<EmployeeDeptDto> findAllDTOEmployees();*/
}
