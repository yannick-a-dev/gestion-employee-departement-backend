package com.gestionemploi.gestionemploiback.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gestionemploi.gestionemploiback.model.Departement;
import com.gestionemploi.gestionemploiback.repository.DepartementRepository;
import com.gestionemploi.gestionemploiback.service.DepartementService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DepartementServiceImpl implements DepartementService{

	private DepartementRepository departementRepository;
	@Override
	public void createDepartement(Departement departement) {
		
		departementRepository.save(departement);
	}

	@Override
	public List<Departement> findDepartement() {
		
		return departementRepository.findAll();
	}

	@Override
	public Departement findOneDepartement(Long id) {
		
		return departementRepository.findById(id).get();
	}

}
