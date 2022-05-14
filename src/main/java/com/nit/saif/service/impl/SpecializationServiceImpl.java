package com.nit.saif.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nit.saif.exception.SpecializationNotFoundException;
import com.nit.saif.model.Specialization;
import com.nit.saif.repository.ISpeciallizationRepository;
import com.nit.saif.service.ISpecializationService;

@Service
public class SpecializationServiceImpl implements ISpecializationService {
	@Autowired
	private ISpeciallizationRepository repository;
	
	@Override
	public String upsort(Specialization spec) {	
		repository.save(spec);
		return "SUCCESS";
	}

	@Override
	public List<Specialization> getAllSpecialization() {
		return repository.findAll();
	}

	@Override
	public Specialization getByIdSpecialization(Long id) {
		Optional<Specialization> opt=repository.findById(id);
		if(opt.isPresent()) {
			return opt.get();
		} else {
			throw new SpecializationNotFoundException("Specialization id "+id+" not exist");
		}	
	}

	@Override
	public String deleteSpecialization(Long id) {
		Optional<Specialization> opt=repository.findById(id);
		if(opt.isPresent()) {
			Specialization spec=opt.get();
			spec.setSpecStatus("No");
			repository.save(spec);
		} else {
			throw new SpecializationNotFoundException("Specialization id "+id+" not exist");
		}	
		return "Specialization ID Deleted successfully";
	}

}
