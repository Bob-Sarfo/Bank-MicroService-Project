package com.mini.bank.domain.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = false)
@Entity
public final class LoanApplication extends Base {
    private int amount;
    @ManyToOne
    private User borrower;
    private int repaymentTerm;
    private double  interestRate;
}
