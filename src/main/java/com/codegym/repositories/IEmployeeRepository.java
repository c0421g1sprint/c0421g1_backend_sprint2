package com.codegym.repositories;

import com.codegym.entity.employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface IEmployeeRepository extends JpaRepository<Employee,Integer> {
//    Thông tin user by Nhật
    @Query(value = "select e.employee_id,e.account_name,e.delete_flag,e.employee_image,a.account_id,a.account_username,a.account_password,e.employee_name,e.employee_address,e.employee_gender,e.employee_phone,e.employee_salary,e.employee_birthday,e.level_id\n" +
            "from employee e inner join account a on e.account_id = a.account_id\n" +
            "where a.account_username= ?1",nativeQuery = true)
    Employee getUserDetail(@Param("name") String name);
}
