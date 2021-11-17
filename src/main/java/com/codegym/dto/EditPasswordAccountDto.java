package com.codegym.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class EditPasswordAccountDto {
    private Integer accountId;
    @NotNull(message = "Mật khẩu không được phép để trống")
    @NotEmpty(message = "Mật khẩu không được phép để trống")
    @Size(min = 5 , max = 20 , message = "Mật khẩu phải từ 5-20 kí tự")
    @Pattern(regexp = "^[0-9a-zA-Z]+$" , message = "Mật khẩu chỉ được chứa chữ cái thường , chữ cái in hoa và số ")
    private String accountPassword;
    private String oldPassword;
    private String confirmPassword;

    public EditPasswordAccountDto() {
    }

    public EditPasswordAccountDto(Integer accountId, @NotNull(message = "Mật khẩu không được phép để trống") @NotEmpty(message = "Mật khẩu không được phép để trống") @Size(min = 5, max = 20, message = "Mật khẩu phải từ 5-20 kí tự") @Pattern(regexp = "^[0-9a-zA-Z]+$", message = "Mật khẩu chỉ được chứa chữ cái thường , chữ cái in hoa và số ") String accountPassword, String oldPassword, String confirmPassword) {
        this.accountId = accountId;
        this.accountPassword = accountPassword;
        this.oldPassword = oldPassword;
        this.confirmPassword = confirmPassword;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public String getAccountPassword() {
        return accountPassword;
    }

    public void setAccountPassword(String accountPassword) {
        this.accountPassword = accountPassword;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
