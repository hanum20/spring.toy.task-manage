package com.oneum.toy.service;


import com.oneum.toy.domain.Account;

public interface AccountService {
    public Account createAccount(Account account);
    public Account updateAccount(Account account);
    public Account getAccount(String username);
    public Account delAccount(Account account);

}
