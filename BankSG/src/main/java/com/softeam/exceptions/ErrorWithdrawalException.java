package com.softeam.exceptions;

public class ErrorWithdrawalException extends Exception {

    public ErrorWithdrawalException() {
        super("The balance should be greater than amount");
    
}
}
