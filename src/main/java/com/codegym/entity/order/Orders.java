package com.codegym.entity.order;

import com.codegym.entity.table.Tables;
import com.codegym.entity.employee.Employee;
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
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderId;

    private double price;

    @ManyToOne(targetEntity = Employee.class)
    @JoinColumn(name = "employee_id", referencedColumnName = "employeeId")
    private Employee employee;

    @OneToMany(mappedBy = "orders")
    Set<OrderDetail> orderDetails;


    @ManyToOne(targetEntity = Tables.class)
    @JoinColumn(name = "table_id",referencedColumnName = "tableId")
    private Tables tables;
}
