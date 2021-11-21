package com.codegym.services.impls;

import com.codegym.entity.account.Account;
import com.codegym.repositories.IAccountRepository;
import com.codegym.services.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements IAccountService {
    @Autowired
    IAccountRepository accountRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void editPassword(Integer id, String password) {
        password = passwordEncoder.encode(password);
        accountRepository.editPassword(id,password);
    }

    @Override
    public Account getAccountById(Integer id) {
        return accountRepository.getAccountById(id);
    }

    @Override
    public Account getAccountByName(String name) {
        return accountRepository.getAccountByName(name);
    }


}
