package com.oneum.toy.repository;

import com.oneum.toy.domain.Account;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;
import java.util.Optional;

@Slf4j
@RunWith(SpringRunner.class)
@DataJpaTest
public class AccountRepositoryTest {

    @Autowired
    private AccountRepository accountRepository;


    @Test
    public void save_account() {
        Account account = Account.builder().username("oneum").password("123123").roles(Collections.singletonList("ROLE_USER")).build();
        account.setPassword("123123");
        account.setUsername("oneum");

        // Create
        accountRepository.save(account);

        // Read
        Optional<Account> account0 = accountRepository.findByUsername("oneum");
        log.info("Read: " + account0.get().toString());

        // Update
        account.setUsername("Han");
        Account savedAccount = accountRepository.save(account);
        log.info("Update: " + savedAccount.getUsername());

        // Delete
        accountRepository.delete(account);
        accountRepository.findByUsername("Han");
        log.info("Delete: " + accountRepository.findAll().toString());


    }

}