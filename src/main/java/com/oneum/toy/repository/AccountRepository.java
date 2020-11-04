package com.oneum.toy.repository;

import com.oneum.toy.domain.Account;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface AccountRepository extends Repository<Account, Long> {

    public Account findByUsername(String username);

    public List<Account> findAll();

    public Account save(Account account);

    public void delete(Account account);
}
