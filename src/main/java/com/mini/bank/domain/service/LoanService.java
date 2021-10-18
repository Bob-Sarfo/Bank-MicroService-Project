package com.mini.bank.domain.service;

import com.mini.bank.domain.exception.LoanApplicationNotFoundException;
import com.mini.bank.domain.exception.UserNotFoundException;
import com.mini.bank.domain.model.Loan;
import com.mini.bank.domain.model.LoanApplication;
import com.mini.bank.domain.model.User;
import com.mini.bank.domain.repository.LoanApplicationRepository;
import com.mini.bank.domain.repository.LoanRepository;
import com.mini.bank.domain.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class LoanService {
    private final UserRepository userRepository;
    private final LoanRepository loanRepository;
    private final LoanApplicationRepository loanApplicationRepository;

    public LoanService(UserRepository userRepository, LoanRepository loanRepository,
                       LoanApplicationRepository loanApplicationRepository) {
        this.userRepository = userRepository;
        this.loanRepository = loanRepository;
        this.loanApplicationRepository = loanApplicationRepository;
    }

    public void acceptLoan(final long loanApplicationId,final long lenderId){
        User lender = userRepository.findById(lenderId).orElseThrow(()->new UserNotFoundException(lenderId));
        LoanApplication loanApplication = loanApplicationRepository.findById(loanApplicationId)
                .orElseThrow(()->new LoanApplicationNotFoundException(loanApplicationId));

        loanRepository.save(new Loan(lender,loanApplication));
    }
}
