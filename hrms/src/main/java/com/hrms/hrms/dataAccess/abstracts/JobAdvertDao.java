package com.hrms.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hrms.hrms.entities.concretes.JobAdvert;
import com.hrms.hrms.entities.dtos.JobAdvertDetails;

public interface JobAdvertDao extends JpaRepository<JobAdvert, Integer> {
	
	public final String getAllJobAdvertQuery= "Select new com.hrms.hrms.entities.dtos.JobAdvertDetails(e.companyName, jp.name, ja.openPositionCount, ja.dueDate)" +
	"From JobAdvert as ja Join ja.employer as e Join ja.jobPosition as jp"; 
	
	@Query(getAllJobAdvertQuery)
	List<JobAdvertDetails> getAllJobAdvertDetails();
	
	@Query(getAllJobAdvertQuery+" where ja.isItActive=true")
	List<JobAdvertDetails> getAllActiveJobAdvertDetails();
	
	@Query(getAllJobAdvertQuery+" order by ja.dueDate asc")
	List<JobAdvertDetails> getByDateAllJobAdvertDetails();
	
	List<JobAdvert> getByEmployer(int employerId);
}