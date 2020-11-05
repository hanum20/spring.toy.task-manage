package com.oneum.toy.service;

import com.oneum.toy.domain.Account;
import com.oneum.toy.repository.AccountRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AccountServiceImpl implements AccountService{

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public void createAccount(Account account) {
        log.debug("User : " + account.toString());
        accountRepository.save(account);
    }

    @Override
    public void updateAccount(Account account) {
        log.debug("User : " + account.toString());
        accountRepository.save(account);
    }

    // 회원가입 시 중복 체크
    @Override
    public boolean checkMembershipByUsername(String username) {
        boolean isMember =
                accountRepository.findByUsername(username) == null ? false : true;
        log.debug("isMember: " + isMember);
        return isMember;
    }

    @Override
    public void delAccount(Long id) {
        Account account = accountRepository.findById(id);
        accountRepository.delete(account);
    }
}
