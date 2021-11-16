package com.codegym.controllers;

import com.codegym.entity.employee.Employee;
import com.codegym.entity.employee.Level;
import com.codegym.services.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/employee")
public class EmployeeController {

    @Autowired
    private IEmployeeService iEmployeeService;


    @GetMapping("/list")
    public ResponseEntity<Page<Employee>> getAllEmployee(@PageableDefault(size = 10) Pageable pageable) {
        Page<Employee> employees = iEmployeeService.getAllEmployee(pageable);
        if (employees.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> findEmployeeById(@PathVariable("id") Integer id) {
        Employee employee = iEmployeeService.findEmployeeById(id);
        if (employee != null) {
            return new ResponseEntity<>(employee, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PatchMapping("/delete/{id}")
    public void deleteEmpoloyee(@PathVariable("id") Integer id) {
        iEmployeeService.deleteEmployee(id);
    }

    @GetMapping("/search")
    public ResponseEntity<Page<Employee>> searchAllEmployee(@PageableDefault(size = 10) Pageable pageable, @RequestParam(required = false) String username, @RequestParam(required = false) String nameEmployee, @RequestParam(required = false) String phone) {
        Page<Employee> employeeList = iEmployeeService.searchEmployee(pageable, username, nameEmployee,phone);
        if (employeeList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(employeeList, HttpStatus.OK);
    }


}
