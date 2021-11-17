package com.codegym.services;

import com.codegym.dto.EmployeeDto;
import com.codegym.entity.employee.Employee;
import com.codegym.entity.employee.Level;

import java.util.List;

public interface IEmployeeService {


    Employee getEmployeeById(int id);

    List<Level> findAllLevelByQuery();

    void update(Employee employee);

    void save(Employee employee);
}
