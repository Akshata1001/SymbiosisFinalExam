package com.employeemanagement.employee.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employeemanagement.employee.entity.Employee;



public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
