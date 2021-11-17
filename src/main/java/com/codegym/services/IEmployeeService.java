package com.codegym.services;

import com.codegym.entity.employee.Employee;
import org.springframework.data.repository.query.Param;

public interface IEmployeeService {
    Employee getUserDetail(String name);
}
