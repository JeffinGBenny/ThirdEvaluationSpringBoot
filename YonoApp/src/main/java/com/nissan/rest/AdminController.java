package com.nissan.rest;

import java.nio.file.AccessDeniedException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nissan.common.APIResponse;
import com.nissan.model.Customer;
import com.nissan.service.IAdminService;
import com.nissan.service.ICustomerService;
import com.nissan.util.JwtUtilAdmin;
import com.nissan.util.JwtUtilCustomer;

@RestController // combination of controller and configuration annotations
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private IAdminService adminService;
	
	@Autowired
	private APIResponse apiresponse;
	
	@Autowired
	private JwtUtilAdmin jwtUtil;
	// list
	@GetMapping("/customer")
	public List<Customer> getCustomer(@RequestHeader(value="authorization",defaultValue="")String auth)throws AccessDeniedException {
		jwtUtil.verify(auth);
		return adminService.getCustomer();
	}

	// search by id
	@GetMapping("/customer/{accountNumber}")
	public Customer getCustomer(@PathVariable String accountNumber,@RequestHeader(value="authorization",defaultValue="")String auth)throws AccessDeniedException {
		jwtUtil.verify(auth);
		return adminService.getCustomer(accountNumber);
	}

	// add employee
	@PostMapping("/customer")
	public ResponseEntity<APIResponse> addCustomer(@RequestBody Customer customer,@RequestHeader(value="authorization",defaultValue="")String auth)throws AccessDeniedException {
		jwtUtil.verify(auth);
		customer.setAccountNo();
		customer.setATMPin();
		if(adminService.saveCustomer(customer)==null) {
			apiresponse.setData("Name can have only alphabets");
			apiresponse.setStatus(500);
			apiresponse.setError("Invalid name");
			
			return ResponseEntity.status(apiresponse.getStatus()).body(apiresponse);
			
		}
		apiresponse.setData("Customer added successfully");
		apiresponse.setStatus(200);
		
		return ResponseEntity.status(apiresponse.getStatus()).body(apiresponse);
	}

	// update
	@PutMapping("/customer")
	public ResponseEntity<APIResponse> updateCustomer(@RequestBody Customer customer,@RequestHeader(value="authorization",defaultValue="")String auth)throws AccessDeniedException {
		jwtUtil.verify(auth);
		adminService.saveCustomer(customer);
		apiresponse.setData("Customer updated successfully");
		apiresponse.setStatus(200);
		
		return ResponseEntity.status(apiresponse.getStatus()).body(apiresponse);

	}

	// disable or delete employee
	@DeleteMapping("/customer/{accountNo}")
	public ResponseEntity<APIResponse> deleteCustomer(@PathVariable int accountNo,@RequestHeader(value="authorization",defaultValue="")String auth) throws AccessDeniedException{
		jwtUtil.verify(auth);
		adminService.deleteCustomer(accountNo);
		apiresponse.setData("Customer deleted successfully");
		apiresponse.setStatus(200);
		
		return ResponseEntity.status(apiresponse.getStatus()).body(apiresponse);
	}

	
	 
	  // search by name
	  
	 /* @GetMapping("/employees/search/{name}") public List<Employee>
	  getAllEmployeesByName(@PathVariable String name,@RequestHeader(value="authorization",defaultValue="")String auth) throws AccessDeniedException{
		  jwtUtil.verify(auth);
		  return employeeService.getEmployee(); }*/
	  
	  // inner join to fetch details from both tables
	  
	  /*@GetMapping("/employees/dto") public List<EmployeeDeptDto>
	  getAllDTOEmployees(@RequestHeader(value="authorization",defaultValue="")String auth)throws AccessDeniedException { 
		  jwtUtil.verify(auth);
		  return employeeService.getAllDtoEmployees(); }*/
}
