package com.mini.bank.domain.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "Users")
public final class User extends Base {

    private String firstName;
    private String lastName;
    private int age;
    private String occupation;
}
