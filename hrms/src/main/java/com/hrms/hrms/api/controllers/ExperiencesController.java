package com.hrms.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hrms.hrms.business.abstracts.ExperienceService;
import com.hrms.hrms.core.utilities.results.DataResult;
import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.entities.concretes.Experience;

@RequestMapping("/api/experiences")
@RestController
public class ExperiencesController {
	
	private ExperienceService experienceService;

	@Autowired
	public ExperiencesController(ExperienceService experienceService) {
		this.experienceService = experienceService;
	}
	
	@GetMapping("/getallsortedbyyear")
	public DataResult<List<Experience>> getAllExperienceByYear(){
		return this.experienceService.getAllExperienceByYear();
	}
	
	@PostMapping
	public Result add(@RequestBody Experience experience) {
		return this.experienceService.add(experience);
	}
	
	
}
