package com.softeam.exceptions;

public class ErrorOperationException extends Exception {

    public ErrorOperationException() {
        super("The amount should be greater than Zero");
    }
}
