package com.nit.saif.validation;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nit.saif.model.Department;
import com.nit.saif.repository.IDepartmentRepository;

@Component
public class DepartmentValidation {
	
	@Autowired
	private IDepartmentRepository repo;
	
	public Map<String,String> deptValidation(@Valid Department dept){
		Map<String,String> errors=new HashMap<>();
		if(repo.existsByDeptName(dept.getDeptName())) {
			errors.put("deptName ", dept.getDeptName()+" already Exists");
		}
		return errors;
	}
}
