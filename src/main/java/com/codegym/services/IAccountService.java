package com.codegym.services;

import com.codegym.entity.account.Account;

public interface IAccountService {



    //PhucNK
    Account findAccountById(Integer AccountId);
    void save(Account account);

//    thêm vào phucnk
    Account findAccountByUserName(String accountName);
}
