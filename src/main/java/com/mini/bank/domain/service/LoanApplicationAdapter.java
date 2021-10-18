package com.mini.bank.domain.service;

import com.mini.bank.application.model.LoanRequest;
import com.mini.bank.domain.exception.UserNotFoundException;
import com.mini.bank.domain.model.LoanApplication;
import com.mini.bank.domain.model.User;
import com.mini.bank.domain.repository.UserRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.time.Duration;

@Log4j2
@Service
public class LoanApplicationAdapter {

    private final UserRepository userRepository;

    public LoanApplicationAdapter(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public LoanApplication transform(LoanRequest loanRequest){
        log.info(loanRequest);
        User user = userRepository.findById(loanRequest.getId()).orElseThrow(() -> new UserNotFoundException(loanRequest.getId()));
        return new LoanApplication(loanRequest.getAmount(), user,loanRequest.getDaysToRepay(), loanRequest.getInterestRate());
    }
}
