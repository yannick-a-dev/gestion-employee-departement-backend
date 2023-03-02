package com.gestionemploi.gestionemploiback.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.gestionemploi.gestionemploiback.model.Employee;
import com.gestionemploi.gestionemploiback.repository.EmployeeRepository;
import com.gestionemploi.gestionemploiback.service.EmployeeService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{

	private EmployeeRepository employeeRepository;
	
	@Override
	public void createEmployee(Employee employee) {
		employeeRepository.save(employee);
		
	}

	@Override
	public List<Employee> getEMployees() {
		
		return employeeRepository.findAll();
	}

	@Override
	public Employee getOneEmployee(Long id) {
		
		return employeeRepository.findById(id).get();
	}

	@Override
	public Map<String, Object> findAllEmployees(int page, int size) {
		try {
			List<Employee> employeeList = new ArrayList<>();
			Pageable paging = PageRequest.of(page, size);
			Page<Employee> pageEmployee = this.employeeRepository.findAll(paging);
			employeeList = pageEmployee.getContent();
			Map<String, Object> employees = new HashMap<>();
			employees.put("employees", employeeList);
			employees.put("pageCurrent", pageEmployee.getNumber());
			employees.put("totalItems", pageEmployee.getTotalElements());
			employees.put("totalPage", pageEmployee.getTotalPages());
			
			return employees;
		} catch (Exception e) {
			throw new RuntimeException();
		}
		
	}

	@Override
	public void delete(Long id) {
		this.employeeRepository.deleteById(id);
		
	}

	@Override
	public Employee update(Employee employee, Long id) {
		Employee employee2 = this.getOneEmployee(id);
		
		employee2.setEmployeePhone(employee.getEmployeePhone());
		employee2.setEmployeeLastName(employee.getEmployeeLastName());
		employee2.setDepartement(employee.getDepartement());
		employee2.setEmployeeFirstName(employee.getEmployeeFirstName());
		
		return this.employeeRepository.save(employee2);
	}

}
