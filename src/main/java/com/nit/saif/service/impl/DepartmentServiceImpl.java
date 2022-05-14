package com.nit.saif.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nit.saif.exception.DepartNotFoundException;
import com.nit.saif.model.Department;
import com.nit.saif.repository.IDepartmentRepository;
import com.nit.saif.service.IDepartmentService;

@Service
public class DepartmentServiceImpl implements IDepartmentService {
	@Autowired
	private IDepartmentRepository repo;

	@Override
	public String upsort(Department dept) {
		repo.save(dept);
		return "SUCCESS";
	}

	@Override
	public List<Department> allDeptData() {
		return repo.findAll();
	}

	@Override
	public Department getOneDeptId(Long id) {
		Optional<Department> opt = repo.findById(id);
		if (opt.isPresent()) {
			return opt.get();
		} else {
			throw new DepartNotFoundException("Department id " + id + "Not Exist");
		}
	}

	@Override
	public String deleteDepartmentId(Long id) {
		Optional<Department> opt = repo.findById(id);
		if (opt.isPresent()) {
			Department dept = opt.get();
			dept.setActiveStatus("NO");
			repo.save(dept);
		} else {
			throw new DepartNotFoundException("Department id " + id + "Not Exist");
		}
		return "Department ID Deleted Suucessfully";
	}

}
