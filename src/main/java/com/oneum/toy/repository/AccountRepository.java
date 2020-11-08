package com.oneum.toy.repository;

import com.oneum.toy.domain.Account;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

public interface AccountRepository extends Repository<Account, Long> {

    public Optional<Account> findByUsername(String username);

    public Account findById(Long id);

    public List<Account> findAll();

    public Account save(Account account);

    public void delete(Account account);
}
