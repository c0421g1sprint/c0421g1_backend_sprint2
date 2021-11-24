package com.codegym.services;

import com.codegym.entity.account.Account;

public interface IAccountService {

    Account findAccountById(Integer AccountId);
    void save(Account account);


//    thêm vào
    Account findAccountByUserName(String accountName);
}
