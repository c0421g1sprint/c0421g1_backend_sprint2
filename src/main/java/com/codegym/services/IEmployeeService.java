package com.codegym.services;


import com.codegym.entity.employee.Employee;
import com.codegym.entity.employee.Level;


import java.util.List;

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


//    thêm tối nay PHUCnk
    List<String> findAccountNameFromEmployee();
}
