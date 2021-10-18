package com.mini.bank.application.controller;

import com.mini.bank.application.model.LoanRequest;
import com.mini.bank.domain.model.LoanApplication;
import com.mini.bank.domain.repository.LoanApplicationRepository;
import com.mini.bank.domain.repository.UserRepository;
import com.mini.bank.domain.service.LoanApplicationAdapter;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.swing.text.html.parser.Entity;
import java.util.List;


@Log4j2
@RestController
public class LoanController {

    private final UserRepository userRepository;
    private final LoanApplicationAdapter loanApplicationAdapter;
    private final LoanApplicationRepository loanApplicationRepository;

    public LoanController(UserRepository userRepository, LoanApplicationAdapter loanApplicationAdapter, LoanApplicationRepository loanApplicationRepository) {
        this.userRepository = userRepository;
        this.loanApplicationAdapter = loanApplicationAdapter;
        this.loanApplicationRepository = loanApplicationRepository;
    }

    @PostMapping("loan/request")
    public void requestLoan(LoanRequest loanRequest){
        log.warn("Raw: "+loanRequest);
        LoanApplication loanApplication = loanApplicationAdapter.transform(loanRequest);
        log.info(loanApplication);
        loanApplicationRepository.save(loanApplication);
        System.out.println(loanRequest);
    }

    @GetMapping("loan/requests")
    public List<LoanApplication> requestAllLoans(){
        return loanApplicationRepository.findAll();
    }

    @PostMapping("loan/accept/{lenderId}/{borrowerId}")
    public void acceptLoan(@PathVariable final String lenderId,@PathVariable final String borrowerId){

    }
    @GetMapping("users")
    public void findUsers(){

    }
}
