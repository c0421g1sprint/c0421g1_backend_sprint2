package com.codegym.services.impls;

import com.codegym.dto.EmployeeDto;
import com.codegym.entity.employee.Employee;
import com.codegym.entity.employee.Level;
import com.codegym.repositories.IEmployeeRepository;
import com.codegym.repositories.ILevel;
import com.codegym.services.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements IEmployeeService {
    @Autowired
    IEmployeeRepository employeeRepository;

    @Autowired
    ILevel iLevel;

    @Override
    public List<Level> findAllLevelByQuery() {
        return iLevel.findAllLevelByQuery();
    }

    @Override
    public Employee getEmployeeById(int id) {
        return employeeRepository.getEmployeeById(id);
    }

    @Override
    public void save(Employee employee) {
        employeeRepository.createNewEmployee(employee.isDeleteFlag(),employee.getEmployeeAddress(),employee.getEmployeeBirthday(),employee.getEmployeeGender(),employee.getEmployeeImage(),employee.getEmployeeName(),employee.getEmployeePhone(),employee.getEmployeeSalary(),employee.getLevel().getLevelId(),employee.getAccountName());
    }




    @Override
    public void update(Employee employee) {
        employeeRepository.updateEmployee(employee.isDeleteFlag(),employee.getEmployeeAddress(),
                employee.getEmployeeBirthday(),employee.getEmployeeGender(),employee.getEmployeeImage(),
                employee.getEmployeeName(),employee.getEmployeePhone(),employee.getEmployeeSalary(),employee.getLevel().getLevelId(),employee.getAccountName(),employee.getEmployeeId());
    }



    @Override
    public Employee getEmployeeByAccountName(String name) {
        return employeeRepository.getEmployeeByAccountName(name);
    }


}
