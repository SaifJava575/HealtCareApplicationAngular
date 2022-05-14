package com.nit.saif.rest;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nit.saif.exception.SpecializationNotFoundException;
import com.nit.saif.model.Specialization;
import com.nit.saif.service.ISpecializationService;
import com.nit.saif.validation.SpecializationValidation;

@RestController
@RequestMapping("/spec")
public class SpecializationController {
	@Autowired
	private ISpecializationService service;
	@Autowired
	private SpecializationValidation validation;
	
	@PostMapping("/register")
	public ResponseEntity<?> saveSpecData(@Valid @RequestBody Specialization spec){
		ResponseEntity<?> response=null;
		Map<String, String> errors=validation.specValidation(spec);
		if(errors.isEmpty()) {
			String status=service.upsort(spec);
			response=ResponseEntity.ok(status);
		} else {
			response=new ResponseEntity<Map<String,String>>
			(errors,HttpStatus.BAD_REQUEST);
		}
		return response;
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Specialization>> getAllSpecialization(){
		ResponseEntity<List<Specialization>> response=null;
		List<Specialization> list=service.getAllSpecialization();
		response=ResponseEntity.ok(list);
		return response;
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<Specialization> getSpecById(@PathVariable Long id){
		ResponseEntity<Specialization> response=null;
		try {
			Specialization spec=service.getByIdSpecialization(id);
			response=ResponseEntity.ok(spec);
		} 
		catch (SpecializationNotFoundException e) {
			e.printStackTrace();
			throw e;
		}
		return response;
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteSpecById(@PathVariable Long id){
		ResponseEntity<String> response=null;
		try {
			String status=service.deleteSpecialization(id);
			response=ResponseEntity.ok(status);
		} 
		catch (SpecializationNotFoundException e) {
			e.printStackTrace();
			throw e;
		}
		return response;
	}
}
