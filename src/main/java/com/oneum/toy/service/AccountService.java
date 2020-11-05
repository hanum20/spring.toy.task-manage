package com.oneum.toy.service;


import com.oneum.toy.domain.Account;

public interface AccountService {
    public void createAccount(Account account);
    public void updateAccount(Account account);
    public boolean checkMembershipByUsername(String username);
    public void delAccount(Long id);

}
