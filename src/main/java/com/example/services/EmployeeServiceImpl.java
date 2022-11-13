package com.example.services;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.example.entities.Employee;
import com.example.repositories.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	@Autowired
	private EmployeeRepository emprepo;
	@Override
	public void registerEmployee(Employee employee) {
		emprepo.save(employee);	
	}
	@Override
	public List<Employee> listAll() {
        return emprepo.findAll();
    }   
	@Override
    public Employee get(String name) {
        return emprepo.save(name);
    }
	@Override
	public void saveEmployee(Employee employee) {
		emprepo.save(employee);
	}
	@Override
	public List<Employee> getEmployees() {
		List<Employee> employees  = emprepo.findAll();
		return employees;
	}
	public void deleteLead(String name) {
		emprepo.deleteAll();
	}
	
	
}