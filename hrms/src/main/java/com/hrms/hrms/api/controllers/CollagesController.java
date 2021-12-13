package com.hrms.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hrms.hrms.business.abstracts.CollageService;
import com.hrms.hrms.core.utilities.results.DataResult;
import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.entities.concretes.Collage;

@RequestMapping("/api/collages")
@RestController
public class CollagesController {

	private CollageService collageService;

	@Autowired
	public CollagesController(CollageService collageService) {
		this.collageService = collageService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Collage collage) {
		return this.collageService.add(collage);
	}
	
	@GetMapping("/getallcollagebyyear")
	public DataResult<List<Collage>> getByAllCollageByYear(){
		return this.collageService.getByAllCollageByYear();
	}
	
	
	
}
