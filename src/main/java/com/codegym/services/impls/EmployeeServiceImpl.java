package com.codegym.services.impls;

import com.codegym.entity.employee.Employee;
import com.codegym.repositories.IEmployeeRepository;
import com.codegym.services.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements IEmployeeService {
    @Autowired
    private IEmployeeRepository employeeRepository;

    @Override
    public Page<Employee> getAllEmployee(Pageable pageable) {
        return employeeRepository.getAllEmployee(pageable);
    }

    @Override
    public Employee findEmployeeById(int id) {
        return employeeRepository.findEmployeeById(id);
    }

    @Override
    public void deleteEmployee(int id) {
        Employee employee = employeeRepository.findEmployeeById(id);
        if (employee != null) {
            employeeRepository.deleteEmployee(employee.getEmployeeId());
        }
    }

    @Override
    public Page<Employee> searchEmployee(Pageable pageable, String username, String nameEmployee, String phone) {
        return employeeRepository.searchEmployeeByAll(pageable,username,nameEmployee,phone);
    }
}
