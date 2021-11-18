package com.codegym.repositories;

import com.codegym.entity.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface IEmployeeRepository extends JpaRepository<Employee,Integer> {
    //MinhNN
    @Query(value = "SELECT employee_id,delete_flag, employee_address, employee_birthday, employee_gender, employee_image,employee_name,employee_phone,employee_salary, account_id,level_id,account_name\n" +
            "FROM employee\n" +
            "WHERE delete_flag = false ",
            countQuery = "select count(*)  from employee where delete_flag = false;"
            ,nativeQuery = true)
    Page<Employee> getAllEmployee(Pageable page);

    //MinhNN
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

    //PhucNK
    @Query(value="select * from employee where employee.employee_id=:id",nativeQuery = true)
    Employee getEmployeeById(int id);

    //PhucNK
    @Modifying
    @Query(value = "INSERT INTO `employee` (`delete_flag`,`employee_address`,`employee_birthday`,`employee_gender`,`employee_image`,`employee_name`,`employee_phone`,`employee_salary`,`level_id`,`account_name`) " +
            "VALUES (?1,?2,?3,?4,?5,?6,?7,?8,?9,?10);",nativeQuery = true)
    void createNewEmployee(Boolean deleteFlag, String address, String birthday, Byte gender, String image, String name, String phone, Double salary, Integer levelId,String accountName);

    //PhucNK
    @Modifying
    @Query(value = "update employee set delete_flag = ?1,employee_address = ?2,employee_birthday= ?3,employee_gender = ?4,employee_image=?5,employee_name=?6,employee_phone=?7,employee_salary=?8,level_id=?9,account_name=?10 where (employee_id = ?11);", nativeQuery = true)
    void updateEmployee(Boolean deleteFlag, String address, String birthday, Byte gender, String image, String name, String phone,Double salary, Integer levelId,String accountName,Integer employeeId);

    //PhucNK
    @Query(value="select * from employee where employee.account_name=:name",nativeQuery = true)
    Employee getEmployeeByAccountName(@Param("name") String name);

}
