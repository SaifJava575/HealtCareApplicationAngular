package com.nit.saif.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nit.saif.model.Department;

public interface IDepartmentRepository extends JpaRepository<Department, Long> {

	public boolean existsByDeptName(String deptName);
}
