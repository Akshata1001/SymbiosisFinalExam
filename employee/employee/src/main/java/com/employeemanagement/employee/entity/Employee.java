package com.employeemanagement.employee.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO.SEQUENCE)
	private int id;
	private String name;
	private String position;
	private String department;
	private String contact;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", position=" + position + ", department=" + department
				+ ", contact=" + contact + "]";
	}
	public Employee(int id, String name, String position, String department, String contact) {
		super();
		this.id = id;
		this.name = name;
		this.position = position;
		this.department = department;
		this.contact = contact;
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
