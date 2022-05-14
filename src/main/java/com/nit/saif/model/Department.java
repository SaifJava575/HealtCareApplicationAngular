package com.nit.saif.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Entity
@Table(name="DEPARTMENT_TABLE")
@Data
public class Department {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="dept_id")
	private Long id;
	
	@Column(name="dept_name")
	@NotBlank(message = "Dept ID cannot be blank")
	private String deptName;
	
	@Column(name="dept_status")
	private String activeStatus;
}
