package com.codegym.controllers;

import com.codegym.dto.EmployeeDto;
import com.codegym.entity.account.Account;
import com.codegym.entity.employee.Employee;
import com.codegym.services.IAccountService;
import com.codegym.services.IEmployeeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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
            return new ResponseEntity<>(employee,HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/createEmployee", method = RequestMethod.POST)
    public ResponseEntity<Employee> saveEmployee(@RequestBody @Validated EmployeeDto employeeDto,BindingResult bindingResult) {
        Employee employeeCheck=iEmployeeService.getEmployeeByAccountName(employeeDto.getAccountName());
        if(employeeCheck!=null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        if (bindingResult.hasFieldErrors()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            Employee employee = new Employee();
            BeanUtils.copyProperties(employeeDto, employee);
            this.iEmployeeService.save(employee);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
    }

    @RequestMapping(value = "/updateEmployee", method = RequestMethod.PATCH)
    public ResponseEntity<?> updateEmployee(@RequestBody  @Validated EmployeeDto employeeDto, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            Employee employee=new Employee();
            BeanUtils.copyProperties(employeeDto,employee);
            this.iEmployeeService.update(employee);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }
}




//    @RequestMapping(value = "/createEmployee", method = RequestMethod.POST)
//    public ResponseEntity<Employee> saveEmployee(@RequestBody  @Validated EmployeeDto employeeDto,BindingResult bindingResult) {
//        if (bindingResult.hasFieldErrors()) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        } else {
//            Employee employee = new Employee();
//            BeanUtils.copyProperties(employeeDto, employee);
//            this.iEmployeeService.save(employee);
//            return new ResponseEntity<>(HttpStatus.CREATED);
//        }
//    }



//    @RequestMapping(value = "/updateEmployee", method = RequestMethod.PATCH)
//    public ResponseEntity<?> updateEmployee(@RequestBody  @Validated EmployeeDto employeeDto, BindingResult bindingResult) {
//        if (bindingResult.hasFieldErrors()) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        } else {
//            Employee employee=new Employee();
//            BeanUtils.copyProperties(employeeDto,employee);
//
//            this.iEmployeeService.update(employee);
//
//            Account account=iAccountService.findAccountById(employee.getAccount().getAccountId());
//            account.setAccountUsername(employee.getAccountName());
//            this.iAccountService.save(account);
//
//            return new ResponseEntity<>(HttpStatus.OK);
//        }
//    }