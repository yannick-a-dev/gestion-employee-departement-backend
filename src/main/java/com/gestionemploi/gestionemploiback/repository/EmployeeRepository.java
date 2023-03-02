package com.gestionemploi.gestionemploiback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestionemploi.gestionemploiback.model.Employee;

import jakarta.transaction.Transactional;

@Transactional
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
