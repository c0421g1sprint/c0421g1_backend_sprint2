package com.codegym.services;

import com.codegym.entity.account.Account;
import org.springframework.data.repository.query.Param;

public interface IAccountService {
    void editPassword(Integer id ,String password);
    Account getAccountById(Integer id);
}
