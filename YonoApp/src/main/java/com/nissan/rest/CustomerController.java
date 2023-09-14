package com.nissan.rest;

import java.nio.file.AccessDeniedException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nissan.common.APIResponse;
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
	
	@GetMapping("/customer/balance/{accountNumber}") public long
	  showBalance(@PathVariable String accountNumber,@RequestHeader(value="authorization",defaultValue="")String auth) throws AccessDeniedException{
		  jwtUtil.verify(auth);
		   return customerService.showBalance(accountNumber);
	}
		  @PutMapping("/customer/deposit/{accountNumber}&{amount}")
		  public ResponseEntity<APIResponse> deposit(@PathVariable String accountNumber,@PathVariable long amount,@RequestHeader(value="authorization",defaultValue="")String auth) throws AccessDeniedException{
			  jwtUtil.verify(auth);
			   customerService.deposit(accountNumber,amount);
			   apiresponse.setData("Amount deposited");
				apiresponse.setStatus(200);
			   return ResponseEntity.status(apiresponse.getStatus()).body(apiresponse);
		  }
		/*  @PutMapping("/customer/deposit/{accountNumber}")
			public void withdraw(@RequestBody Customer customer,@RequestHeader(value="authorization",defaultValue="")String auth)throws AccessDeniedException {
				jwtUtil.verify(auth);
				customerService.saveCustomer(customer);

			}*/
		  
		  @PutMapping("/customer/withdraw/{accountNumber}&{amount}")
		  public ResponseEntity<APIResponse> withdraw(@PathVariable String accountNumber,@PathVariable long amount,@RequestHeader(value="authorization",defaultValue="")String auth) throws AccessDeniedException{
			  jwtUtil.verify(auth);
			   customerService.withdraw(accountNumber,amount);
			   apiresponse.setData("Amount withdrawn");
				apiresponse.setStatus(200);
			   return ResponseEntity.status(apiresponse.getStatus()).body(apiresponse);
		  }
		  
		  @PutMapping("/customer/transfer/{senderAccountNumber}&{receiverAccountNumber}&{amount}")
		  public ResponseEntity<APIResponse> transfer(@PathVariable String senderAccountNumber,@PathVariable String receiverAccountNumber,@PathVariable long amount,@RequestHeader(value="authorization",defaultValue="")String auth) throws AccessDeniedException{
			  jwtUtil.verify(auth);
			   customerService.transferWithdraw(senderAccountNumber,amount);
			   customerService.transferDeposit(receiverAccountNumber,amount);
			   apiresponse.setData("Amount tranferred");
				apiresponse.setStatus(200);
			   return ResponseEntity.status(apiresponse.getStatus()).body(apiresponse);
		  }
		  
}

