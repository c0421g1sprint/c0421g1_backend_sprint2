package com.codegym.services;

import com.codegym.entity.employee.Employee;
import com.codegym.entity.employee.Level;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IEmployeeService {

    //PhucNK
    Employee getEmployeeById(int id);

    //PhucNK
    List<Level> findAllLevelByQuery();

    //PhucNK
    void update(Employee employee);

    //PhucNK
    void save(Employee employee);

    //PhucNK
    Employee getEmployeeByAccountName( String name);

    //MinhNN
    Page<Employee> getAllEmployee(Pageable pageable);

    //MinhNN
    void deleteEmployee(int id);

    //MinhNN
    Page<Employee> searchEmployee(Pageable pageable, String username, String nameEmployee, String phone);

    //NhatDV
    Employee getUserDetail(String name);

    //    thêm tối nay PHUCnk
    List<String> findAccountNameFromEmployee();
}
