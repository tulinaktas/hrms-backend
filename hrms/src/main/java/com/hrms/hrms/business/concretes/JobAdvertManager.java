package com.hrms.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.hrms.hrms.business.abstracts.JobAdvertService;
import com.hrms.hrms.core.utilities.results.DataResult;
import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.core.utilities.results.SuccessDataResult;
import com.hrms.hrms.core.utilities.results.SuccessResult;
import com.hrms.hrms.dataAccess.abstracts.JobAdvertDao;
import com.hrms.hrms.entities.concretes.JobAdvert;
import com.hrms.hrms.entities.dtos.JobAdvertDetails;


@Service
public class JobAdvertManager implements JobAdvertService {

	private JobAdvertDao jobAdvertDao;
	
	@Autowired
	public JobAdvertManager(JobAdvertDao jobAdvertDao) {
		this.jobAdvertDao = jobAdvertDao;
	}
	
	@Override
	public Result add(JobAdvert jobAdvert) {
		this.jobAdvertDao.save(jobAdvert);
		return new SuccessResult();
	}

	@Override
	public DataResult<List<JobAdvert>> getAll() {
		return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertDao.findAll());
	}

	@Override
	public DataResult<List<JobAdvert>> getAllSortedDueDate() {
		Sort sort = Sort.by(Sort.Direction.ASC,"dueDate");
		return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertDao.findAll(sort));
	}

	@Override
	public DataResult<List<JobAdvert>> getByEmployer(int employerId) {
		return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertDao.getByEmployer(employerId));
	}

	@Override
	public DataResult<List<JobAdvertDetails>> getAllJobAdvertDetails() {
		return new SuccessDataResult<List<JobAdvertDetails>>(this.jobAdvertDao.getAllJobAdvertDetails());
	}

	@Override
	public DataResult<List<JobAdvertDetails>> getAllActiveJobAdvertDetails() {
		return new SuccessDataResult<List<JobAdvertDetails>>(this.jobAdvertDao.getAllActiveJobAdvertDetails());
	}

	@Override
	public DataResult<List<JobAdvertDetails>> getByDateAllJobAdvertDetails() {
		return new  SuccessDataResult<List<JobAdvertDetails>>(this.jobAdvertDao.getByDateAllJobAdvertDetails());
	}

}
