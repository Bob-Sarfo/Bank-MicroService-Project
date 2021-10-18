package com.mini.bank.domain.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.time.LocalDate;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = false)
@Entity
public class Loan extends Base{
    @ManyToOne
    private  User borrower;
    @ManyToOne
    private User lender;
    private  int amount;
    private double interestRate;
    private LocalDate dateLent;
    private LocalDate dateDue;

    public Loan(User lender, LoanApplication loanApplication) {
        this.lender = lender;
        this.borrower=loanApplication.getBorrower();
        this.amount = loanApplication.getAmount();
        this.interestRate= loanApplication.getInterestRate();
    }
}
