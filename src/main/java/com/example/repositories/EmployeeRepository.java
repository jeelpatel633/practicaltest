package com.example.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entities.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	Employee save(String name);

}
