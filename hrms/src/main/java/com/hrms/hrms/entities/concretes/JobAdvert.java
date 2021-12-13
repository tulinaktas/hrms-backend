package com.hrms.hrms.entities.concretes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="job_adverts")
@NoArgsConstructor
@AllArgsConstructor
public class JobAdvert {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="job_definition")
	private String jobDefinition;
	
	@Column(name="city")
	private String city;
	
	@Column(name="min_salary")
	private double minSalary;
	
	@Column(name="max_salary")
	private double maxSalary;
	
	@Column(name="open_position")
	private int openPositionCount;
	
	@Column(name="due_date")
	private Date dueDate;
	
	@Column(name="is_it_active")
	private boolean isItActive;
	
	@ManyToOne()
	@JoinColumn(name="position_id")
	private JobPosition jobPosition;
	
	@ManyToOne()
	@JoinColumn(name="employer_id")
	private Employer employer;
}
