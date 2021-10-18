package com.mini.bank.domain.model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Base {
    @Id
    @GeneratedValue
    private long id;
}
