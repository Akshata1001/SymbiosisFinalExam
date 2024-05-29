package com.employeemanagement.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.employeemanagement.employee.entity.Employee;
import com.employeemanagement.employee.services.EmployeeService;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@Controller
@Transactional
public class EmployeeController {
	
	private EmployeeService employeeservice;

	@Autowired
	public EmployeeController(EmployeeService employeeservice) {
		super();
		this.employeeservice = employeeservice;
	}
	//Create Operation
	@GetMapping("/create")
	public String saveEmployee(Model model) {
		model.addAttribute("employee", new Employee());
		return "addemployee" ;	
	}
	
	@PostMapping("/saveemployee")
	public String getStatus(@Valid @ModelAttribute("employee") Employee employee, BindingResult bindResult) {
		if(bindResult.hasErrors()) {
			return "addemployee";
		}
		employeeservice.saveEmployee(employee);
		return "redirect:/read";
	}
	
	//Read Operation
	@GetMapping("/read")
	public String displayAllEmployee(Model model){
		List<Employee> employeelist =employeeservice.getAllEmployee();
		model.addAttribute("employee", employeelist );
		return "display";
	}
	
	//Delete Operation
	@PostMapping("/employee/delete")
	public String deleteEmp(@RequestParam("id") int empID, Model model) {
		employeeservice.deleteEmployee(empID);
		String deleteMessage ="employee succesfully deleated with ID:"+empID;
		model.addAttribute("message", deleteMessage);
		return "redirect:/read";
	}
	
	//Update Operation
	@GetMapping("/employee/update")
	public String updateEmp(@RequestParam("id") int id, Model model) {
		Employee employee =employeeservice.findByID(id);
		model.addAttribute("employee", employee);
		return "updateForm";		
	}
	
	@PostMapping("/saveupdate")
	public String getUpdate(@Valid @ModelAttribute("employee") Employee employee, BindingResult bindresult) {
		System.out.println(bindresult.getAllErrors());
		if(bindresult.hasErrors()) {
			return "updateForm";
		}
		employeeservice.updateEmployee(employee);
		return "redirect:/read";
		
	}

	
}



