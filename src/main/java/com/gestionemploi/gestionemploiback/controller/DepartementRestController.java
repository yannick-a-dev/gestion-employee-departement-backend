package com.gestionemploi.gestionemploiback.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestionemploi.gestionemploiback.dto.DepartementDto;
import com.gestionemploi.gestionemploiback.model.Departement;
import com.gestionemploi.gestionemploiback.service.DepartementService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping(value="/api")
@CrossOrigin("*")
public class DepartementRestController {

	private DepartementService departementService;
	
	@PostMapping("/departements")
	void createDepartement(@RequestBody DepartementDto departementDto) {
		Departement departement = new Departement();
		departement.setDepartementName(departementDto.getDepartementName());
		departementService.createDepartement(departement);
	}
	
	@GetMapping("/departements")
	List<Departement> Departements(){
		return departementService.findDepartement();
	}
	
	@GetMapping("/departements/{id}")
	Departement getOneDepartement(@PathVariable Long id) {
		return departementService.findOneDepartement(id);
	}
}
