package com.nit.saif.service;

import java.util.List;

import com.nit.saif.model.Department;

public interface IDepartmentService {
	
	public String upsort(Department dept);
	public List<Department> allDeptData();
	public Department getOneDeptId(Long id);
	public String deleteDepartmentId(Long id);
}
