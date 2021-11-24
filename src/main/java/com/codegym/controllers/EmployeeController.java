package com.codegym.controllers;

import com.codegym.dto.EmployeeDto;
import com.codegym.entity.account.Account;
import com.codegym.entity.employee.Employee;
import com.codegym.entity.employee.Level;
import com.codegym.services.IAccountService;
import com.codegym.services.IEmployeeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/employee")
public class EmployeeController {
    @Autowired
    IEmployeeService iEmployeeService;

    @Autowired
    IAccountService iAccountService;

    @GetMapping("/{id}")
    public ResponseEntity<Employee> findEmployeeById(@PathVariable int id) {
        Employee employee = iEmployeeService.getEmployeeById(id);
        if (employee != null) {
            return new ResponseEntity<>(employee, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @GetMapping("/listAccountName")
    public ResponseEntity<List<String>> getAccountNameList() {
        List<String> accountList = iEmployeeService.findAccountNameFromEmployee();
//        if (accountList.isEmpty()) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        } else {
//            return new ResponseEntity<>(accountList, HttpStatus.OK);
//        }
        return new ResponseEntity<>(accountList, HttpStatus.OK);
    }





    @PostMapping(value = "/createEmployee")
    public ResponseEntity<Employee> saveEmployee(@RequestBody @Validated EmployeeDto employeeDto, BindingResult bindingResult) {
        Employee employeeCheck = iEmployeeService.getEmployeeByAccountName(employeeDto.getAccountName());
        if (employeeCheck != null) {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }

//thêm vào sáng ngày 25/11 2 giờ sáng
        new EmployeeDto().validate(employeeDto,bindingResult);

        if (bindingResult.hasFieldErrors()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            Employee employee = new Employee();
            BeanUtils.copyProperties(employeeDto, employee);

            this.iEmployeeService.save(employee);

//            this.updateEmployeeAccount(employee);

//            Employee employeeUpdate=iEmployeeService.getEmployeeById(employee.getEmployeeId());
//            System.out.println(employeeUpdate);
//            Account account=iAccountService.findAccountByUserName(employee.getAccountName());
//            employee.setAccount(account);
//            this.iEmployeeService.save(employee);

            return new ResponseEntity<>(HttpStatus.CREATED);
        }
    }

//    public  void updateEmployeeAccount(Employee employee){
//        Employee employeeUpdate=iEmployeeService.getEmployeeById(employee.getEmployeeId());
//        System.out.println(employeeUpdate);
//
//            Account account=iAccountService.findAccountByUserName(employee.getAccountName());
//            employee.setAccount(account);
//            this.iEmployeeService.save(employee);
//
//    }


    @PatchMapping(value = "/updateEmployee" )
    public ResponseEntity<?> updateEmployee(@RequestBody @Validated EmployeeDto employeeDto, BindingResult bindingResult) {


        //thêm vào sáng ngày 25/11 2 giờ sáng
        new EmployeeDto().validate(employeeDto,bindingResult);


        if (bindingResult.hasFieldErrors()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            Employee employee = new Employee();
            BeanUtils.copyProperties(employeeDto, employee);
            this.iEmployeeService.update(employee);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    @GetMapping("/listLevel")
    public ResponseEntity<List<Level>> getLevelList
            () {
        List<Level> levelList = iEmployeeService.findAllLevelByQuery();
        if (levelList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(levelList, HttpStatus.OK);
        }
    }
}


























