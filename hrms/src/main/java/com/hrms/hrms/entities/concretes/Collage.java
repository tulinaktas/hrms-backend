package com.hrms.hrms.entities.concretes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="collage")
@NoArgsConstructor
@AllArgsConstructor
public class Collage {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int collageId;
	
	@NotNull
	@Column(name = "collage_name")
	private String collageName;
	
	@NotNull
	@Column(name = "departmant_name")
	private String departmantName;
	
	@NotNull
	@Column(name = "start_date")
	private Date startDate;
	
	@Column(name = "due_date")
	private Date dueDate;
	
	private boolean isGraudated; //true ise due date dolu -- false ise due date bos olabilir ---> dusunmeceli
	
}
