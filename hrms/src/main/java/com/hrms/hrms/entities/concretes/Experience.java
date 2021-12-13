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
@Table(name="experience")
@NoArgsConstructor
@AllArgsConstructor
public class Experience {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int experienceId;
	
	@NotNull
	@Column(name = "company_name")
	private String companyName;
	
	@NotNull
	@Column(name = "start_date")
	private Date startDate;
	
	@NotNull
	@Column(name = "due_date")
	private Date dueDate;
	
	private boolean isWorked; //true --> hala çalışıyor // false --> calisma bitis tarihi yani dueDate olacak ---> dusunmeceli
}
