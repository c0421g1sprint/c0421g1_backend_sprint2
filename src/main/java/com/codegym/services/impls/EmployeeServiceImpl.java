package com.codegym.services.impls;


import com.codegym.entity.employee.Employee;
import com.codegym.entity.employee.Level;
import com.codegym.repositories.IEmployeeRepository;
import com.codegym.repositories.ILevel;
import com.codegym.services.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

    //PhucNK
    @Autowired
    IEmployeeRepository employeeRepository;

    //PhucNK
    @Autowired
    ILevel iLevel;

    //PhucNK
    @Override
    public List<Level> findAllLevelByQuery() {
        return iLevel.findAllLevelByQuery();
    }

    //PhucNK
    @Override
    public Employee getEmployeeById(int id) {
        return employeeRepository.getEmployeeById(id);
    }

    //PhucNK
    @Override
    public void save(Employee employee) {
        employeeRepository.createNewEmployee(employee.isDeleteFlag(),employee.getEmployeeAddress(),employee.getEmployeeBirthday(),employee.getEmployeeGender(),employee.getEmployeeImage(),employee.getEmployeeName(),employee.getEmployeePhone(),employee.getEmployeeSalary(),employee.getLevel().getLevelId(),employee.getAccountName());
    }

    //PhucNK
    @Override
    public void update(Employee employee) {
        employeeRepository.updateEmployee(employee.isDeleteFlag(),employee.getEmployeeAddress(),
                employee.getEmployeeBirthday(),employee.getEmployeeGender(),employee.getEmployeeImage(),
                employee.getEmployeeName(),employee.getEmployeePhone(),employee.getEmployeeSalary(),employee.getLevel().getLevelId(),employee.getEmployeeId());
    }

    //PhucNK
    @Override
    public Employee getEmployeeByAccountName(String name) {
        return employeeRepository.getEmployeeByAccountName(name);
    }

    //MinhNN
    @Override
    public Page<Employee> getAllEmployee(Pageable pageable) {
        return employeeRepository.getAllEmployee(pageable);
    }


    //MinhNN
    @Override
    public void deleteEmployee(int id) {
        Employee employee = employeeRepository.getEmployeeById(id);
        if (employee != null) {
            employeeRepository.deleteEmployee(employee.getEmployeeId());
        }
    }

    //MinhNN
    @Override
    public Page<Employee> searchEmployee(Pageable pageable, String username, String nameEmployee, String phone) {
        return employeeRepository.searchEmployeeByAll(pageable,username,nameEmployee,phone);
    }

    //NhatDV
    @Override
    public Employee getUserDetail(String name) {
        return employeeRepository.getUserDetail(name);
    }

//    thêm tối nay phucnk
    @Override
    public List<String> findAccountNameFromEmployee() {
        return employeeRepository.findAccountNameFromEmployee();
    }
}
