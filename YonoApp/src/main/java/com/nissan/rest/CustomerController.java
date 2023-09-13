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
import com.nissan.service.ICustomerService;
import com.nissan.util.JwtUtilCustomer;

@RestController // combination of controller and configuration annotations
@RequestMapping("/api")
public class CustomerController {
	@Autowired
	private ICustomerService customerService;
	
	@Autowired
	private APIResponse apiresponse;
	
	@Autowired
	private JwtUtilCustomer jwtUtil;
	/*
	// list
	@GetMapping("/customer")
	public List<Customer> getCustomer(@RequestHeader(value="authorization",defaultValue="")String auth)throws AccessDeniedException {
		jwtUtil.verify(auth);
		return customerService.getCustomer();
	}

	// search by id
	@GetMapping("/employees/{id}")
	public Customer getCustomer(@PathVariable int id,@RequestHeader(value="authorization",defaultValue="")String auth)throws AccessDeniedException {
		jwtUtil.verify(auth);
		return customerService.getCustomer(id);
	}

	// add employee
	@PostMapping("/customer")
	public ResponseEntity<APIResponse> addCustomer(@RequestBody Customer customer,@RequestHeader(value="authorization",defaultValue="")String auth)throws AccessDeniedException {
		jwtUtil.verify(auth);
		if(customerService.saveCustomer(customer)==null) {
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
	public void updateCustomer(@RequestBody Customer customer,@RequestHeader(value="authorization",defaultValue="")String auth)throws AccessDeniedException {
		jwtUtil.verify(auth);
		customerService.saveCustomer(customer);

	}

	// disable or delete employee
	@DeleteMapping("/employees/{id}")
	public void deleteCustomer(@PathVariable int id,@RequestHeader(value="authorization",defaultValue="")String auth) throws AccessDeniedException{
		jwtUtil.verify(auth);
		customerService.deleteCustomer(id);
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
	@GetMapping("/customer/balance/{accountNumber}") public void
	  showBalance(@PathVariable String accountNumber,@RequestHeader(value="authorization",defaultValue="")String auth) throws AccessDeniedException{
		  jwtUtil.verify(auth);
		   customerService.showBalance(accountNumber);
		  
		/*  @PutMapping("/customer/deposit/{accountNumber}")
			public void deposit(@PathVariable String accountNumber,@PathVariable long amount,@RequestHeader(value="authorization",defaultValue="")String auth)throws AccessDeniedException {
				jwtUtil.verify(auth);
				customerService.deposit(accountNumber,amount);

			}
		  
		  @PutMapping("/customer/deposit/{accountNumber}")
			public void withdraw(@RequestBody Customer customer,@RequestHeader(value="authorization",defaultValue="")String auth)throws AccessDeniedException {
				jwtUtil.verify(auth);
				customerService.saveCustomer(customer);

			}*/
		  
}
}
