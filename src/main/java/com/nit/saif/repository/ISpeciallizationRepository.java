package com.nit.saif.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nit.saif.model.Specialization;

public interface ISpeciallizationRepository extends JpaRepository<Specialization,Long> {
	
	public boolean existsBySpecName(String specName);
}
