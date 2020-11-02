package com.oneum.toy.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity
@Data
public class Account {

    @Id
    @GeneratedValue
    private Long id;

    // private String email;

    @NotEmpty
    private String username;

    @NotEmpty
    private String password;
}
