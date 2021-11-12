package com.codegym.repositories;

import com.codegym.entity.employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface IEmployeeRepository extends JpaRepository<Employee,Integer> {
}
