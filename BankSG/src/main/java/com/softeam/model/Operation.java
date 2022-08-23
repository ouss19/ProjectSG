package com.softeam.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

public class Operation {

    private LocalDate operationDate;
    private BigDecimal amount;
    private BigDecimal balance;
    private OperationType operationType;

    public LocalDate getOperationDate() {
	return operationDate;
    }

    public void setOperationDate(LocalDate operationDate) {
	this.operationDate = operationDate;
    }

    public BigDecimal getAmount() {
	return amount;
    }

    public void setAmount(BigDecimal amount) {
	this.amount = amount;
    }

    public OperationType getOperationType() {
	return operationType;
    }

    public void setOperationType(OperationType operationType) {
	this.operationType = operationType;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

}
