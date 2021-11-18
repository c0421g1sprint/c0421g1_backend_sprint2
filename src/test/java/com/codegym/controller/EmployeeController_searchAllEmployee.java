package com.codegym.controller;

import com.codegym.controllers.EmployeeController;
import com.codegym.entity.employee.Employee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SpringBootTest
public class EmployeeController_searchAllEmployee {
    @Autowired
    private EmployeeController employeeController;


    @Test
    public void  searchAllEmployee_7() {
        ResponseEntity<Page<Employee>> pageResponseEntity = this.employeeController.searchAllEmployee(PageRequest.of(0,10),null,null,null);
        Assertions.assertEquals(HttpStatus.OK, pageResponseEntity.getStatusCode());
    }


    @Test
    public void  searchAllEmployee_8() {
        ResponseEntity<Page<Employee>> pageResponseEntity = this.employeeController.searchAllEmployee(PageRequest.of(0,10),"","", "");
        Assertions.assertEquals(HttpStatus.OK, pageResponseEntity.getStatusCode());
        Page<Employee> studentPage = pageResponseEntity.getBody();

        Assertions.assertEquals(18, studentPage.getTotalElements());
        Assertions.assertEquals(2, studentPage.getTotalPages());

    }

    @Test
    public void  searchAllEmployee_9() {
        ResponseEntity<Page<Employee>> pageResponseEntity = this.employeeController.searchAllEmployee(PageRequest.of(0,10),"user100","abc","0909232732");
        Assertions.assertEquals(HttpStatus.NOT_FOUND, pageResponseEntity.getStatusCode());
    }

    @Test
    public void  searchAllEmployee_10() {
        ResponseEntity<Page<Employee>> pageResponseEntity = this.employeeController.searchAllEmployee(PageRequest.of(0,1),"admin123","minh", "0901234568");
        Assertions.assertEquals(HttpStatus.NOT_FOUND, pageResponseEntity.getStatusCode());
    }



    @Test
    public void searchAllEmployee_11() {
        ResponseEntity<Page<Employee>> pageResponseEntity
                = this.employeeController.searchAllEmployee(PageRequest.of(0, 10),"user","","");
        Assertions.assertEquals(HttpStatus.OK, pageResponseEntity.getStatusCode());

        Page<Employee> employees = pageResponseEntity.getBody();

        Assertions.assertEquals(18, employees.getTotalElements());
        Assertions.assertEquals(2, employees.getTotalPages());
        Assertions.assertEquals("Nguyễn Tiến Danh", employees.getContent().get(0).getEmployeeName());

    }
}
