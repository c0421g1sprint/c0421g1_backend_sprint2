package com.codegym.dto;

import com.codegym.entity.account.Account;
import com.codegym.entity.employee.Level;
import com.codegym.entity.order.Orders;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {
    private Integer employeeId;

    private String employeeName;

    private String employeeAddress;

    private String employeePhone;

    private String employeeImage;

    private Byte employeeGender;

    private String employeeBirthday;

    private double employeeSalary;

    private boolean deleteFlag;

    private Level level;

    private Account account;

    private Set<Orders> ordersSet;

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Set<Orders> getOrdersSet() {
        return ordersSet;
    }

    public void setOrdersSet(Set<Orders> ordersSet) {
        this.ordersSet = ordersSet;
    }
}
