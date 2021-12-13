package com.hrms.hrms.business.abstracts;

import java.util.List;

import com.hrms.hrms.core.utilities.results.DataResult;
import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.entities.concretes.JobAdvert;
import com.hrms.hrms.entities.dtos.JobAdvertDetails;

public interface JobAdvertService {
	Result add(JobAdvert jobAdvert);
	DataResult<List<JobAdvert>> getAll();
	DataResult<List<JobAdvert>> getAllSortedDueDate();
	DataResult<List<JobAdvert>> getByEmployer(int employerId);
	DataResult<List<JobAdvertDetails>> getAllJobAdvertDetails();
	DataResult<List<JobAdvertDetails>> getAllActiveJobAdvertDetails();
	DataResult<List<JobAdvertDetails>> getByDateAllJobAdvertDetails();
}
