package com.codegym.dto;

import com.codegym.entity.account.Account;
import com.codegym.entity.employee.Level;
import com.codegym.entity.order.Orders;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
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

    private String accountName;

    private Level level;

    private Account account;

    private Set<Orders> ordersSet;
}
