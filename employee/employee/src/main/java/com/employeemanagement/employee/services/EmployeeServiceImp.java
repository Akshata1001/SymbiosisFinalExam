package com.employeemanagement.employee.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employeemanagement.employee.dao.EmployeeRepository;
import com.employeemanagement.employee.entity.Employee;

@Service
public class EmployeeServiceImp implements EmployeeService {

	
	private EmployeeRepository employeeRepo;
	
	
	@Autowired
	public EmployeeServiceImp(EmployeeRepository employeeRepo) {
		super();
		this.employeeRepo = employeeRepo;
	}

	@Override
	public Employee saveEmployee(Employee emp) {
		// TODO Auto-generated method stub
		return employeeRepo.save(emp);
	}

	@Override
	public List<Employee> getAllEmployee() {
		// TODO Auto-generated method stub
		List<Employee> findAll =employeeRepo.findAll();
		return findAll;
	}

	@Override
	public void deleteEmployee(int id) {
		// TODO Auto-generated method stub
		 employeeRepo.deleteById(id);
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return employeeRepo.save(employee);
	}

	@Override
	public Employee findByID(int id) {
		Optional<Employee> findByid=employeeRepo.findById(id);
		Employee emp=findByid.get();
		return emp;
	}

	
}
	
	
