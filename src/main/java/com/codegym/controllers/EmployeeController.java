package com.codegym.controllers;

import com.codegym.dto.EmployeeDto;
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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;


@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/employee")
public class EmployeeController {
    //PhucNK
    @Autowired
    IEmployeeService iEmployeeService;

    //PhucNK
    @Autowired
    IAccountService iAccountService;

    //PhucNK
    @GetMapping("/{id}")
    public ResponseEntity<Employee> findEmployeeById(@PathVariable int id) {
        Employee employee = iEmployeeService.getEmployeeById(id);
        if (employee != null) {
            return new ResponseEntity<>(employee, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //MinhNN
    @GetMapping("/list")
    public ResponseEntity<Page<Employee>> getAllEmployee(@PageableDefault(size = 10) Pageable pageable) {
        Page<Employee> employees = iEmployeeService.getAllEmployee(pageable);
        if (employees.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    //MinhNN
    @PatchMapping("/delete/{id}")
    public void deleteEmployee(@PathVariable("id") Integer id) {
        iEmployeeService.deleteEmployee(id);
    }

    //MinhNN
    @GetMapping("/search")
    public ResponseEntity<Page<Employee>> searchAllEmployee(@PageableDefault(size = 10) Pageable pageable,
                                                            @RequestParam(required = false) String username,
                                                            @RequestParam(required = false) String nameEmployee,
                                                            @RequestParam(required = false) String phone) {
        Page<Employee> employeeList = iEmployeeService.searchEmployee(pageable, username, nameEmployee, phone);
        if (employeeList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(employeeList, HttpStatus.OK);
    }


    //PhucNK
    @RequestMapping(value = "/createEmployee", method = RequestMethod.POST)
    public ResponseEntity<Employee> saveEmployee(@RequestBody @Validated EmployeeDto employeeDto, BindingResult bindingResult) {
        Employee employeeCheck = iEmployeeService.getEmployeeByAccountName(employeeDto.getAccountName());
        if (employeeCheck != null) {
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

    //PhucNK
    @RequestMapping(value = "/updateEmployee", method = RequestMethod.PATCH)
    public ResponseEntity<?> updateEmployee(@RequestBody @Validated EmployeeDto employeeDto, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            Employee employee = new Employee();
            BeanUtils.copyProperties(employeeDto, employee);
            this.iEmployeeService.update(employee);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }
}
