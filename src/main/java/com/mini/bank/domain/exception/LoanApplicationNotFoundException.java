package com.mini.bank.domain.exception;

public class LoanApplicationNotFoundException extends RuntimeException {
    public LoanApplicationNotFoundException(long userId) {
        super("Loan application with Id : " + userId);
    }
}
