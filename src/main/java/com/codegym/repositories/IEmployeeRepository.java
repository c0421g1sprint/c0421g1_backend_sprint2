package com.codegym.repositories;

import com.codegym.entity.employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface IEmployeeRepository extends JpaRepository<Employee,Integer> {
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

//    thêm vào tối ngayf24/11 PHUCnK
    @Query(value="select employee.account_name from employee",nativeQuery=true)
    List<String> findAccountNameFromEmployee();

}
