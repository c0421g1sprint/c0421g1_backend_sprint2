package com.codegym.services.impls;

import com.codegym.repositories.IEmployeeRepository;
import com.codegym.services.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements IEmployeeService {
    @Autowired
    IEmployeeRepository employeeRepository;
}
