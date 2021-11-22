package com.codegym.services;

import com.codegym.entity.account.Account;

public interface IAccountService {
    void editPassword(Integer id, String password);

    Account getAccountById(Integer id);

    Account getAccountByName(String name);

    //DungNM 21/11
    Account findByUsername(String username);

    //DungNM 21/11
    void signUp(Account account);

    //DungNM 21/11
    Account findAccountByEmail(String email);
}
