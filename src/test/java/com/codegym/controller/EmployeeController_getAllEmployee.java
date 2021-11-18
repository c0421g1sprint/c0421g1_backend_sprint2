package com.codegym.controller;

import com.codegym.controllers.EmployeeController;
import com.codegym.entity.employee.Employee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SpringBootTest
public class EmployeeController_getAllEmployee {

    @Autowired
    private EmployeeController employeeController;


    @Test
    public void getAllEmployee_5(){
        ResponseEntity<Page<Employee>> pageResponseEntity
                = this.employeeController.getAllEmployee(PageRequest.of(0, 10));

        Assertions.assertEquals(HttpStatus.NOT_FOUND, pageResponseEntity.getStatusCode());
    }


    @Test
    public void getAllEmployee_6() {
        ResponseEntity<Page<Employee>> pageResponseEntity
                = this.employeeController.getAllEmployee(PageRequest.of(0, 10));
        Assertions.assertEquals(HttpStatus.OK, pageResponseEntity.getStatusCode());

        Page<Employee> employeePage =pageResponseEntity.getBody();
        Assertions.assertEquals(18,employeePage.getTotalElements());
        Assertions.assertEquals(2,employeePage.getTotalPages());
        Assertions.assertEquals("Nguyễn Tiến Danh",employeePage.getContent().get(0).getEmployeeName());
    }
}
