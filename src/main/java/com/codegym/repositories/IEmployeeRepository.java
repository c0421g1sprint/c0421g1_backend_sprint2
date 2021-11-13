package com.codegym.repositories;

import com.codegym.entity.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface IEmployeeRepository extends JpaRepository<Employee,Integer> {
    @Query(value = "SELECT e.employee_id, e.employee_address, e.employee_birthday, e.employee_gender, e.employee_image,e.employee_name,e.employee_phone,e.employee_salary, e.account_id,e.level_id\n" +
            "FROM employee e", nativeQuery = true)
    Page<Employee> getAllEmployee();

    @Query(value= "SELECT e.employee_id, e.employee_address, e.employee_birthday, e.employee_gender, e.employee_image,e.employee_name,e.employee_phone,e.employee_salary, e.account_id,e.level_id\n" +
            "FROM employee e\n" +
            "WHERE employee_id = ?1", nativeQuery = true)
    Employee findEmployeeById(Integer id);

    @Query(value="e.employee_id, e.employee_address, e.employee_birthday, e.employee_gender, e.employee_image,e.employee_name,e.employee_phone,e.employee_salary, e.account_id,e.level_id\n" +
            "FROM employee e\n" +
            "JOIN account a ON a.account_id = e.account_id\n" +
            "JOIN `level` l ON l.level_id = e.level_id", nativeQuery = true)
    Page<Employee> searchEmployeeByAll();
}
