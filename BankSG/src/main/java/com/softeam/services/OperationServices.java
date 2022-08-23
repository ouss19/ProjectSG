package com.softeam.services;

import java.math.BigDecimal;
import java.util.List;

import com.softeam.exceptions.ErrorOperationException;
import com.softeam.exceptions.ErrorWithdrawalException;
import com.softeam.model.Account;
import com.softeam.model.Operation;

public interface OperationServices {

    void doDeposit(Account account, BigDecimal amount) throws ErrorOperationException;

    void doWithdrawal(Account account, BigDecimal amount) throws ErrorWithdrawalException, ErrorOperationException;

    List<Operation> checkOperationsHistory(Account account);

}
