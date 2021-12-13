package com.hrms.hrms.entities.concretes;

import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Entity
@Table(name="contact")
@NoArgsConstructor
@AllArgsConstructor
public class Contact {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int contactId;
	
	@NotNull
	@Column(name = "github")
	private String githubLink;
	
	
	@NotNull
	@Column(name = "linkedin")
	private String linkedinLink;
}
