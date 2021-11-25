package com.codegym.services.impls;

import com.codegym.email_java.ConfirmService;
import com.codegym.email_java.VerifyEmail;
import com.codegym.email_java.email.EmailSender;
import com.codegym.entity.account.Account;
import com.codegym.repositories.IAccountRepository;
import com.codegym.services.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class AccountServiceImpl implements IAccountService {
    @Autowired
    IAccountRepository accountRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private ConfirmService confirmService;

    @Autowired
    private EmailSender emailSender;

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

    @Override
    public void editPassword(Integer id, String password) {
        password = passwordEncoder.encode(password);
        accountRepository.editPassword(id, password);
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

    ////DungNM 21/11 - UserDetailService use this function
    @Override
    public Account findByUsername(String username) {
        return this.accountRepository.findAccountByUsername(username);
    }

    ////DungNM 21/11 - Register account and send Email to verify
    @Transactional
    public void signUp(Account account) {
        Account registerAccount = this.accountRepository.findAccountByUsername(account.getAccountUsername());
        if (registerAccount != null) {
            throw new IllegalStateException("username haved already exist");
        }
        registerAccount = this.accountRepository.findAccountByEmail(account.getEmail());
        if (registerAccount != null) {
            throw new IllegalStateException("email haved already exist");
        }
        String encode = passwordEncoder.encode(account.getAccountPassword());
        account.setAccountPassword(encode);
        this.accountRepository.signUpAccount(account.getAccountUsername(), account.getAccountPassword(), account.getEmail());
        registerAccount = this.accountRepository.findAccountByUsername(account.getAccountUsername());
        this.accountRepository.setRoleForUser(registerAccount.getAccountId());
        String token = UUID.randomUUID().toString();
        VerifyEmail verifyEmail = new VerifyEmail(
                token, registerAccount.getEmail(),
                LocalDateTime.now(), LocalDateTime.now().plusMinutes(15));
        this.confirmService.saveTokenSendByEmail(verifyEmail);
        String link = "http://localhost:8080/api/public/confirm?token=" + token;
        String contentEmail = emailSender.buildRegisterEmail(link);
        emailSender.send(registerAccount.getEmail(), contentEmail);
    }

    //DungNM 21/11 - findAccount By email
    @Override
    public Account findAccountByEmail(String email) {
        return this.accountRepository.findAccountByEmail(email);
    }
}
