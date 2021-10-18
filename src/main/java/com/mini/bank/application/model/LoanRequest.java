package com.mini.bank.application.model;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
public final class LoanRequest {
    @Id
    @GeneratedValue
    private long id;
    private int amount;
    private long borrowerId;
    private int daysToRepay;
    private double interestRate;
}
