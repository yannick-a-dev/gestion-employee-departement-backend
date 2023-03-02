package com.gestionemploi.gestionemploiback.service;

import java.util.List;

import com.gestionemploi.gestionemploiback.model.Departement;

public interface DepartementService {

	void createDepartement(Departement departement);
	List<Departement> findDepartement();
	Departement findOneDepartement(Long id);
}
