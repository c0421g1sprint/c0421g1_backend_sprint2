package com.codegym.repositories;

import com.codegym.entity.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface IEmployeeRepository extends JpaRepository<Employee,Integer> {
    @Query(value = "SELECT employee_id,delete_flag, employee_address, employee_birthday, employee_gender, employee_image,employee_name,employee_phone,employee_salary, account_id,level_id,account_name\n" +
            "FROM employee\n" +
            "WHERE delete_flag = false ",
            countQuery = "select count(*)  from employee where delete_flag = false;"
            ,nativeQuery = true)
    Page<Employee> getAllEmployee(Pageable page);

    @Query(value= "SELECT e.employee_id,e.delete_flag, e.employee_address, e.employee_birthday, e.employee_gender, e.employee_image,e.employee_name,e.employee_phone,e.employee_salary, e.account_id,e.level_id,account_name\n" +
            "FROM employee e\n" +
            "WHERE employee_id = ?1", nativeQuery = true)
    Employee findEmployeeById(Integer id);

    @Modifying
    @Query(value = "update employee set delete_flag = true where employee_id = :id ", nativeQuery = true)
    void deleteEmployee(Integer id);

    @Query(value="SELECT e.employee_id,e.delete_flag, e.employee_address, e.employee_birthday, e.employee_gender, e.employee_image,e.employee_name,e.employee_phone,e.employee_salary, e.account_id,e.level_id,account_name\n" +
            "FROM employee e\n" +
            "JOIN account a ON a.account_id = e.account_id\n" +
            "JOIN `level` l ON l.level_id = e.level_id\n" +
            "WHERE e.delete_flag = false AND (?1 IS NULL OR a.account_username LIKE %?1%) AND (?2 IS NULL OR e.employee_name LIKE %?2%) AND (?3 IS NULL OR e.employee_phone LIKE %?3%)",
            countQuery = "SELECT COUNT(*)\n" +
            "FROM employee e\n" +
            "JOIN account a ON a.account_id = e.account_id\n" +
            "JOIN `level` l ON l.level_id = e.level_id\n" +
            "WHERE e.delete_flag = false AND (?1 IS NULL OR a.account_username LIKE %?1%) AND (?2 IS NULL OR e.employee_name LIKE %?2%) AND (?3 IS NULL OR e.employee_phone LIKE %?3%)"
            ,nativeQuery = true)
    Page<Employee> searchEmployeeByAll(Pageable page, String username, String nameEmployee, String phone);
}
