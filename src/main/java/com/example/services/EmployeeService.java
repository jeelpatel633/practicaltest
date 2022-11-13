package com.example.services;

import java.util.List;

import com.example.entities.Employee;

public interface EmployeeService {
	
	public void registerEmployee(Employee employee);
	public void saveEmployee(Employee employee);
	 public Employee get(String name);
	 public List<Employee> listAll();
	public List<Employee> getEmployees();
	public void deleteLead(String name);
}
