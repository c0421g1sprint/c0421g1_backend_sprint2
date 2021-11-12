package com.codegym.services.impls;

import com.codegym.repositories.IAccountRepository;
import com.codegym.services.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements IAccountService {
    @Autowired
    IAccountRepository accountRepository;
}
