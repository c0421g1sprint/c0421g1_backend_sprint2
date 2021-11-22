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

    //PhucNK
    @Override
    public Account findAccountById(Integer AccountId) {
        return accountRepository.findAccountById(AccountId);
    }

    //PhucNK
    @Override
    public void save(Account account) {
        accountRepository.save(account);
    }

    //NhatDV
    @Autowired
    private PasswordEncoder passwordEncoder;

    //NhatDV
    @Override
    public void editPassword(Integer id, String password) {
        password = passwordEncoder.encode(password);
        accountRepository.editPassword(id,password);
    }

    //NhatDV
    @Override
    public Account getAccountById(Integer id) {
        return accountRepository.getAccountById(id);
    }

    //NhatDV
    @Override
    public Account getAccountByName(String name) {
        return accountRepository.getAccountByName(name);
    }
}
