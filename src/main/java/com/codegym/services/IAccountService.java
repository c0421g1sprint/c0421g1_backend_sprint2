package com.codegym.services;

import com.codegym.entity.account.Account;

public interface IAccountService {
    //PhucNK
    Account findAccountById(Integer AccountId);
    //PhucNK
    void save(Account account);
}
