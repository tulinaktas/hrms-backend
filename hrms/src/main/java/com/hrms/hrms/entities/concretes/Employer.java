package com.hrms.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="employers")
@EqualsAndHashCode(callSuper=false)
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobAdverts"})
@PrimaryKeyJoinColumn(name="id")
public class Employer extends User{
	
	@Column(name="company_name")
	private String companyName;
	
	@Column(name="website")
	private String webSite;
	
	@Column(name="phone_number")
	private String phoneNumber;
	
	@OneToMany(mappedBy="employer")
	private List<JobAdvert> jobAdverts;
}
