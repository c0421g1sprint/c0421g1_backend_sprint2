package com.codegym.services.impls;

import com.codegym.entity.account.Account;
import com.codegym.repositories.IAccountRepository;
import com.codegym.services.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements IAccountService {

    //PhucNK
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
//thêm vao 11/24 phucNk
    @Override
    public Account findAccountByUserName(String accountName) {
        return accountRepository.findAccountByUserName(accountName);
    }
}
