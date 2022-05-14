package com.nit.saif.service;

import java.util.List;

import com.nit.saif.model.Specialization;

public interface ISpecializationService {
	
	public String upsort(Specialization spec);
	public List<Specialization> getAllSpecialization();
	public Specialization getByIdSpecialization(Long id);
	public String  deleteSpecialization(Long id);
}
