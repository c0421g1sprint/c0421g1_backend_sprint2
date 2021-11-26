package com.codegym.entity.employee;

import com.codegym.entity.order.Orders;
import com.codegym.entity.account.Account;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer employeeId;
    private String employeeName;
    private String employeeAddress;
    private String employeePhone;


    @Column(columnDefinition = "LONGTEXT")
    private String employeeImage;
    private Byte employeeGender;
    private String employeeBirthday;
    private double employeeSalary;
    private boolean deleteFlag;

    //tu them vao PhucNK
    private String accountName;

    @ManyToOne(targetEntity = Level.class)
    @JoinColumn(name = "level_id", referencedColumnName = "levelId")
    private Level level;

    @OneToOne
    @JoinColumn(name = "account_id", referencedColumnName = "accountId")
    private Account account;

    @JsonBackReference(value = "employee_orders")
    @OneToMany(mappedBy = "employee")
    private Set<Orders> ordersSet;
}
