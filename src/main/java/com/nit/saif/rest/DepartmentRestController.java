package com.nit.saif.rest;

import java.util.HashMap;
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

import com.nit.saif.exception.DepartNotFoundException;
import com.nit.saif.model.Department;
import com.nit.saif.service.IDepartmentService;
import com.nit.saif.validation.DepartmentValidation;

@RestController
@RequestMapping("/dept")
public class DepartmentRestController {
	@Autowired
	private IDepartmentService service;
	@Autowired
	private DepartmentValidation validation;
	
	@PostMapping("/register")
	public ResponseEntity<?> saveDeptData(@Valid @RequestBody Department dept){
		ResponseEntity<?> response=null;
		Map<String,String> errors=validation.deptValidation(dept);
		if(errors.isEmpty()) {
			String message=service.upsort(dept);
			response=ResponseEntity.ok(message);
		} else {
			response=new ResponseEntity<Map<String,String>>
			(errors,HttpStatus.BAD_REQUEST);
		}
		return response;
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Department>> allDeptData(){
		ResponseEntity<List<Department>> response=null;
		List<Department> list=service.allDeptData();
		response=ResponseEntity.ok(list);
		return response;
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<Department> getOneDeptIdData(@PathVariable Long id){
		ResponseEntity<Department> response=null;
		try {
			Department dept=service.getOneDeptId(id);
			response=ResponseEntity.ok(dept);
		} 
		catch (DepartNotFoundException e) {
			e.printStackTrace();
			throw e;
		}
		return response;
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteDepart(@PathVariable Long id){
		ResponseEntity<String> response=null;
		try {
			String status=service.deleteDepartmentId(id);
			response=ResponseEntity.ok(status);
		}
		catch (DepartNotFoundException e) {
			e.printStackTrace();
			throw e;
		}
		return response;
	}
}
