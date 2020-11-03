package com.oneum.toy.repository;

import com.oneum.toy.domain.Account;
import org.springframework.data.repository.Repository;

public interface AccountRepository extends Repository<Account, Long> {

    public Account findByUsername(String username);

    public void save(Account account);
}
