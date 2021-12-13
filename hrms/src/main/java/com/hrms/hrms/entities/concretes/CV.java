/*package com.hrms.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class CV {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne()
	@JoinColumn(name = "candidate_id")
	private Candidate candidate;
	
	@OneToOne(mappedBy = "cv")
	private Photo photo;
	
	@OneToMany(mappedBy = "cv")
	private List<Collage> collages;
	
	@OneToMany(mappedBy = "cv")
	private List<Skill> skills;
	
	@OneToMany(mappedBy = "cv")
	private List<Experience> experiences;
	
	@OneToMany(mappedBy = "cv")
	private List<Language> languages;
	
	@OneToOne(mappedBy = "cv")
	private Contact contact;
}*/
