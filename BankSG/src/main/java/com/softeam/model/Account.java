package com.softeam.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.softeam.exceptions.ErrorOperationException;
import com.softeam.exceptions.ErrorWithdrawalException;

public class Account {

    String accountId;
    BigDecimal balance;
    LocalDate openingDate;
    List<Operation> operations;

    public Account() {

	this.balance = new BigDecimal(0);
	this.operations = new ArrayList<Operation>();
	this.openingDate = LocalDate.now();
    }

    public String getAccountId() {
	return accountId;
    }

    public void setAccountId(String accountId) {
	this.accountId = accountId;
    }

    public BigDecimal getBalance() {
	return balance;
    }

    public void setBalance(BigDecimal balance) {
	this.balance = balance;
    }

    public LocalDate getOpeningDate() {
	return openingDate;
    }

    public void setOpeningDate(LocalDate openingDate) {
	this.openingDate = openingDate;
    }

    public List<Operation> getOperations() {
	return operations;
    }

    public void setOperations(List<Operation> operations) {
	this.operations = operations;
    }

    public void doDeposit(BigDecimal amount) throws ErrorOperationException {

	if (amount.compareTo(new BigDecimal(0)) > 0) {
	    Operation operation = new Operation();
	    operation.setAmount(amount);
	    operation.setOperationType(OperationType.DEPOSIT);
	    operation.setOperationDate(LocalDate.now());
	    this.setBalance(this.balance.add(amount));
	    operation.setBalance(this.getBalance());
	    this.getOperations().add(operation);

	} else {
	    throw new ErrorOperationException();
	}

    }

    public void doWithdrawal(BigDecimal amount) throws ErrorWithdrawalException, ErrorOperationException {

	if (amount.compareTo(new BigDecimal(0)) > 0) {
	    if (this.balance.compareTo(amount) >= 0) {

		Operation operation = new Operation();
		operation.setAmount(amount);
		operation.setOperationDate(LocalDate.now());
		operation.setOperationType(OperationType.WITHDRAWAL);
		this.setBalance(this.balance.subtract(amount));
		operation.setBalance(this.getBalance());
		this.getOperations().add(operation);

	    }

	    else {
		throw new ErrorWithdrawalException();
	    }
	} else {
	    throw new ErrorOperationException();
	}

    }

    public List<Operation> checkOperationsHistory(Account account) {
	account.getOperations().forEach(e -> {
	    System.out.println("OperationType is " + e.getOperationType().toString() + " *** Amount is: "
		    + e.getAmount() + " *** Date Of Operation is " + e.getOperationDate()
		    + " *** Balance after this Operation is: " + e.getBalance());
	});
	System.out.println("The current balance is " + account.getBalance());
	return account.getOperations();
    }
}