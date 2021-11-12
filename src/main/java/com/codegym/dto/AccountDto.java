package com.codegym.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Setter
@Getter
public class AccountDto {
    @NotBlank
    @NotNull
    private String accountUsername;

    @NotBlank
    @NotNull
    private String accountPassword;

    @Email
    private String email;
    private boolean deleteFlag;
    private boolean activeFlag;
}
