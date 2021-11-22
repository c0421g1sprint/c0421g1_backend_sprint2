package com.codegym.services;

import com.codegym.entity.account.Account;

public interface IAccountService {
    //PhucNK
    Account findAccountById(Integer AccountId);

    //PhucNK
    void save(Account account);

    //NhatDV
    void editPassword(Integer id, String password);

    //NhatDV
    Account getAccountById(Integer id);

    //NhatDV
    Account getAccountByName(String name);
}
