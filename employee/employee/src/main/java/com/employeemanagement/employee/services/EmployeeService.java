package com.employeemanagement.employee.services;

import java.util.List;

import com.employeemanagement.employee.entity.Employee;


public interface EmployeeService {
	
public Employee saveEmployee(Employee emp);
	
		
	public void deleteEmployee(int id);
	
	public Employee findByID(int id);

	
	public Employee updateEmployee(Employee employee);

	List<Employee> getAllEmployee();

}
