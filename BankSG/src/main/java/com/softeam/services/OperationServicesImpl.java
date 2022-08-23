package com.softeam.services;

import java.math.BigDecimal;
import java.util.List;

import com.softeam.exceptions.ErrorOperationException;
import com.softeam.exceptions.ErrorWithdrawalException;
import com.softeam.model.Account;
import com.softeam.model.Operation;

public class OperationServicesImpl implements OperationServices {

    @Override
    public void doDeposit(Account account, BigDecimal amount) throws ErrorOperationException {
	account.doDeposit(amount);

    }

    @Override
    public void doWithdrawal(Account account, BigDecimal amount)
	    throws ErrorWithdrawalException, ErrorOperationException {
	account.doWithdrawal(amount);
    }

    @Override
    public List<Operation> checkOperationsHistory(Account account) {
	return account.checkOperationsHistory(account);

    }

}
