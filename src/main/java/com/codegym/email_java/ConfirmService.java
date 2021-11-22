package com.codegym.email_java;

import com.codegym.repositories.IAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class ConfirmService {
    @Autowired
    private ConfirmRepository repository;

    @Autowired
    private IAccountRepository accountRepository;

    public void saveTokenSendByEmail(VerifyEmail verifyEmail) {
        repository.save(verifyEmail);
    }

    public void confirmEmailWithToken(String token) {
        Optional<VerifyEmail> optionalVerifyEmail = this.repository.findByToken(token);
        if (!optionalVerifyEmail.isPresent()) {
            throw new IllegalStateException("Token can not found");
        }
        LocalDateTime expireAt = optionalVerifyEmail.get().getExpireAt();
        if (expireAt.isBefore(LocalDateTime.now())) {
            throw new IllegalStateException("Expire verify token");
        }
        optionalVerifyEmail.get().setConfirmAt(LocalDateTime.now());
        this.repository.save(optionalVerifyEmail.get());
        this.accountRepository.enableActiveAccount(optionalVerifyEmail.get().getEmail());
    }
}