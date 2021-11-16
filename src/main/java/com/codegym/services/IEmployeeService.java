package com.codegym.services;

import com.codegym.entity.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IEmployeeService {

    Page<Employee> getAllEmployee(Pageable pageable);

    Employee findEmployeeById(int id);

    void deleteEmployee(int id);

    Page<Employee> searchEmployee(Pageable pageable, String username, String nameEmployee, String phone);
}
