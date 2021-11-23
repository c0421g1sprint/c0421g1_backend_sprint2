package com.codegym.controllers;

import com.codegym.dto.EditPasswordAccountDto;
import com.codegym.dto.LoginRequestDto;
import com.codegym.entity.account.Account;
import com.codegym.jwt_token.JwtProvider;
import com.codegym.jwt_token.ResponseToken;
import com.codegym.services.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/account")
public class AccountController {
    @Autowired
    private IAccountService accountService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private JwtProvider tokenProvider;


    //NhatDV code accout by id
    @GetMapping(value = "/{accountId}")
    public ResponseEntity<Account> editPassword(@PathVariable Integer accountId) {
        Account account = accountService.getAccountById(accountId);
        if (account == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(account, HttpStatus.OK);
        }
    }

    // NhatDV code getAccountByName
    @GetMapping("/userName")
    public ResponseEntity<Account> findUserDetail(@RequestParam("name") String name) {
        Account account = accountService.getAccountByName(name);
        if (account != null) {
            return new ResponseEntity<>(account, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

    }

    // NhatDV code edit password
    @PatchMapping(value = "/editPass", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> editPassword(@RequestBody @Valid EditPasswordAccountDto editPasswordAccountDto, BindingResult bindingResult) {
        Integer id = editPasswordAccountDto.getAccountId();
        Account account = accountService.getAccountById(id);
        if (!passwordEncoder.matches(editPasswordAccountDto.getOldPassword(), account.getAccountPassword())
                || bindingResult.hasFieldErrors()
                || !editPasswordAccountDto.getConfirmPassword().equals(editPasswordAccountDto.getAccountPassword())) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {

            accountService.editPassword(editPasswordAccountDto.getAccountId(), editPasswordAccountDto.getAccountPassword());
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    //DungNM 21/11 - login API use to authentication by HttpBasic 23/10
    @PostMapping("/login")
    public ResponseEntity<ResponseToken> loginAccount(@Valid @RequestBody LoginRequestDto loginRequestDto, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequestDto.getUsername(), loginRequestDto.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        UserDetails user = userDetailsService.loadUserByUsername(loginRequestDto.getUsername());
        System.out.println(user.toString());
        List<String> roles = new ArrayList<>();
        for (GrantedAuthority items : user.getAuthorities()) {
            roles.add(items.getAuthority());
        }
        String token = tokenProvider.generateToken(user);
        return new ResponseEntity<>(new ResponseToken(token, user.getUsername(), roles), HttpStatus.OK);
    }
}
