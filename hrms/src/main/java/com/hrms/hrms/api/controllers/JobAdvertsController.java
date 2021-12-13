package com.hrms.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hrms.hrms.business.abstracts.JobAdvertService;
import com.hrms.hrms.core.utilities.results.DataResult;
import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.entities.concretes.JobAdvert;
import com.hrms.hrms.entities.dtos.JobAdvertDetails;

@RestController
@RequestMapping("/api/jobadverts")
public class JobAdvertsController {
	
	private JobAdvertService jobAdvertService;
	
	@Autowired
	public JobAdvertsController(JobAdvertService jobAdvertService) {
		this.jobAdvertService = jobAdvertService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody JobAdvert jobAdvert) {
		return this.jobAdvertService.add(jobAdvert);
	}
	
	@GetMapping("/getall")
	public DataResult<List<JobAdvert>> getAll(){
		return this.jobAdvertService.getAll();
	}
	
	@GetMapping("/getdetails")
	public DataResult<List<JobAdvertDetails>> getAllJobAdvertDetails(){
		return this.jobAdvertService.getAllJobAdvertDetails();
	}

	@GetMapping("/getactivedetails")
	public DataResult<List<JobAdvertDetails>> getAllActiveJobAdvertDetails(){
		return this.jobAdvertService.getAllActiveJobAdvertDetails();
	}
	
	@GetMapping("/getbydatedetails")
	public DataResult<List<JobAdvertDetails>> getByDateAllJobAdvertDetails(){
		return this.jobAdvertService.getByDateAllJobAdvertDetails();
	}
	
}
