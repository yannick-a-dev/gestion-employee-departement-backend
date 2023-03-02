package com.gestionemploi.gestionemploiback.service;

import java.util.List;
import java.util.Map;

import com.gestionemploi.gestionemploiback.model.Employee;

public interface EmployeeService {

	void createEmployee(Employee employee);
	List<Employee> getEMployees();
	Employee getOneEmployee(Long id);
	//pagination
	Map<String, Object> findAllEmployees(int page, int size);
	
	void delete(Long id);
	
	Employee update(Employee employee, Long id);
}
