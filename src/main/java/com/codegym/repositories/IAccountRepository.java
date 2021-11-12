package com.codegym.repositories;

import com.codegym.entity.account.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface IAccountRepository extends JpaRepository<Account,Integer> {
}
