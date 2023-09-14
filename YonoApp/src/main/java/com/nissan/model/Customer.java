package com.nissan.model;

import java.util.Random;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer {
	@Id
	@Column(name = "accountNo")
	private String accountNo ;
	
	@Column(name = "customerName", nullable = false, length = 60)
	private String customerName;
	
	@Column(name = "accountType", nullable = false, length = 60)
	private String accountType;
	
	@Column(name = "balance")
	private Long balance;
	
	@Column(name = "minimumBalance")
	private Long minimumBalance;
	
	@Column(name = "mobileNumber")
	private Long mobileNumber;
	
	@Column(name = "emailId")
	private String emailId;
	
	@Column(name = "ATMPin")
	private Integer ATMPin;
	
	@Column(name = "isActive")
	private Integer isActive;
	

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo() {
		long min = 100000000L; // Smallest 9-digit number
        long max = 999999999L; // Largest 9-digit number
        Random random = new Random();
        long accountNo1 = min + (long) (random.nextDouble() * (max - min + 1));
		String accountNo2=String.valueOf(accountNo1);
		this.accountNo = accountNo2;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public Long getBalance() {
		return balance;
	}

	public void setBalance(Long balance) {
		this.balance = balance;
	}

	public Long getMinimumBalance() {
		return minimumBalance;
	}

	public void setMinimumBalance(Long minimumBalance) {
		this.minimumBalance = minimumBalance;
	}

	public Long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Integer getATMPin() {
		return ATMPin;
	}

	public void setATMPin() {
		Random random = new Random();
		int aTMPin= random.nextInt(1000);
		this.ATMPin = 1000+aTMPin;
	}
	
	

}
