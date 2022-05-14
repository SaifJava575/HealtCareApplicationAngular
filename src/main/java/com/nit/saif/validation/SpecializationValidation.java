package com.nit.saif.validation;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nit.saif.model.Specialization;
import com.nit.saif.repository.ISpeciallizationRepository;

@Component
public class SpecializationValidation {
	@Autowired
	private ISpeciallizationRepository repo;
	
	public Map<String,String> specValidation(@Valid Specialization spec){
		Map<String,String> errors=new HashMap<>();
		
		if(repo.existsBySpecName(spec.getSpecName())) {
			errors.put("specName", spec.getSpecName()+"Alredy exists");
		}
		return errors;
	}
}
