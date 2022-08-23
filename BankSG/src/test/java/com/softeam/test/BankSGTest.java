package com.softeam.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.softeam.exceptions.ErrorOperationException;
import com.softeam.exceptions.ErrorWithdrawalException;
import com.softeam.model.Account;
import com.softeam.services.OperationServices;
import com.softeam.services.OperationServicesImpl;

public class BankSGTest {

    private Account account;
    private static OperationServices operationService;
    @BeforeEach
    void setUp() {
	account = new Account();

    }
    
    @BeforeAll
	static void  setUpBeforeClass() {
	operationService = new OperationServicesImpl();
	}
    /// US 1

    @Test
    public void NegativeAmountShouldDoDepositReturnErrorOperationException() {

	assertThrows(ErrorOperationException.class, () -> {
	    operationService.doDeposit(account, new BigDecimal(-1));

	});

    }

    @Test
    public void shouldDoDepositAddAmountCorreclty() throws ErrorOperationException {

	operationService.doDeposit(account, new BigDecimal(28));
	assertEquals(new BigDecimal(28), account.getBalance());

    }

    // US2

    @Test
    public void NegativeAmountShouldDoWithDrawalReturnErrorOperationException() {

	assertThrows(ErrorOperationException.class, () -> {
	    operationService.doWithdrawal(account, new BigDecimal(-1));

	});

    }

    @Test
    public void shouldDoWithDrawalSubstractAmountCorreclty() throws ErrorOperationException, ErrorWithdrawalException {

	operationService.doDeposit(account, new BigDecimal(28));
	operationService.doWithdrawal(account, new BigDecimal(20));
	assertEquals(new BigDecimal(8), account.getBalance());

    }

    @Test
    public void amountGreaterThanBalanceShouldDoWithDrawalReturnErrorWithdrawalException()
	    throws ErrorOperationException {

	operationService.doDeposit(account, new BigDecimal(28));

	assertThrows(ErrorWithdrawalException.class, () -> {
	    operationService.doWithdrawal(account,new BigDecimal(29));

	});

    }
    // US 3

    @Test
    public void shouldDisplayCorrectOperationsInfos() throws ErrorOperationException, ErrorWithdrawalException {

	operationService.doDeposit(account, new BigDecimal(30));
	operationService.doDeposit(account,new BigDecimal(15));
	operationService.doWithdrawal(account, new BigDecimal(10));

	assertEquals(new BigDecimal(35), account.getBalance());
	assertEquals(3, operationService.checkOperationsHistory(account).size());
	
    }
}
