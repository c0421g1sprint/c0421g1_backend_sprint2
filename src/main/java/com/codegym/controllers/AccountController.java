package com.codegym.controllers;

import com.codegym.dto.EditPasswordAccountDto;
import com.codegym.entity.account.Account;
import com.codegym.entity.employee.Employee;
import com.codegym.services.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/account")
public class AccountController {
    @Autowired
    private IAccountService accountService;
    @Autowired
    private PasswordEncoder passwordEncoder;

//NhatDV code accout by id
    @GetMapping(value = "/{accountId}")
    public ResponseEntity<Account> editPassword (@PathVariable Integer accountId ) {
        Account account = accountService.getAccountById(accountId);
        if (account == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>( account,HttpStatus.OK);
        }
// NhatDV code getAccountByName
    }
    @GetMapping("/userName")
    public ResponseEntity<Account> findUserDetail(@RequestParam("name") String name) {
        Account account = accountService.getAccountByName(name);
        if (account!=null) {
            return new ResponseEntity<>(account, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

    }

// NhatDV code edit password
    @PatchMapping( value = "/editPass" , consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> editPassword (@RequestBody @Valid EditPasswordAccountDto editPasswordAccountDto , BindingResult bindingResult) {
        Integer id = editPasswordAccountDto.getAccountId();
        Account account = accountService.getAccountById(id);
        if (!passwordEncoder.matches(editPasswordAccountDto.getOldPassword(), account.getAccountPassword())
                || bindingResult.hasFieldErrors()
                ||!editPasswordAccountDto.getConfirmPassword().equals(editPasswordAccountDto.getAccountPassword()))  {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {

            accountService.editPassword(editPasswordAccountDto.getAccountId(), editPasswordAccountDto.getAccountPassword());
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

}
