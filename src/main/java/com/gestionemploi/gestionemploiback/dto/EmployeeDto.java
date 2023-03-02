package com.gestionemploi.gestionemploiback.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {

	private String employeeFirstName;
	private String employeeLastName;
	private String employeePhone;
	private Long departementId;
}
