package com.gestionemploi.gestionemploiback.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gestionemploi.gestionemploiback.dto.EmployeeDto;
import com.gestionemploi.gestionemploiback.model.Employee;
import com.gestionemploi.gestionemploiback.service.DepartementService;
import com.gestionemploi.gestionemploiback.service.EmployeeService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(value="/api")
@AllArgsConstructor
@CrossOrigin("*")
public class EmployeeRestController {

	private EmployeeService employeeService;
	
	private DepartementService departementService;
	
	@PostMapping("/employees")
	void createEmployee(@RequestBody EmployeeDto employeeDto) {
		Employee employee2 = new Employee();
		employee2.setEmployeeLastName(employeeDto.getEmployeeLastName());
		employee2.setEmployeePhone(employeeDto.getEmployeePhone());
		employee2.setEmployeeFirstName(employeeDto.getEmployeeFirstName());
		employee2.setDepartement(departementService.findOneDepartement(employeeDto.getDepartementId()));
		employeeService.createEmployee(employee2);
	}
	
	@GetMapping("/employees")
	List<Employee> findAllEMployees(){
		return employeeService.getEMployees();
	}
	@GetMapping("/employees/{id}")
	Employee getOneEmployee(@PathVariable Long id) {
		return employeeService.getOneEmployee(id);
		
	}
	
	@GetMapping("/employees/paging")
	public ResponseEntity<Map<String, Object>> findAllByPaging(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "2") int size) {
		return new ResponseEntity<>(this.employeeService.findAllEmployees(page, size), HttpStatus.OK);
	}
	
	@DeleteMapping("/employees/delete/{id}")
	public void deleteEmployee(@PathVariable Long id) {
		this.employeeService.delete(id);
	}
	
	@PutMapping("/employees/update/{id}")
	public Employee updateEmployee(@RequestBody EmployeeDto employeeDto, @PathVariable Long id) {
		Employee employee = new Employee();
		employee.setEmployeeLastName(employeeDto.getEmployeeLastName());
		employee.setEmployeeFirstName(employeeDto.getEmployeeFirstName());
		employee.setEmployeePhone(employeeDto.getEmployeePhone());
		employee.setDepartement(this.departementService.findOneDepartement(employeeDto.getDepartementId()));
		
		return this.employeeService.update(employee, id);
	}
}
