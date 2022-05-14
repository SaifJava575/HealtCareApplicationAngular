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
@Table(name="SPECIALIZATION")
@Data
public class Specialization {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="spec_id")
	private Long specId;
	
	@Column(name="spec_name")
	@NotBlank(message = "Spec Id Cannot be null")
	private String specName;
	
	@Column(name="spec_status")
	private String specStatus;
}
