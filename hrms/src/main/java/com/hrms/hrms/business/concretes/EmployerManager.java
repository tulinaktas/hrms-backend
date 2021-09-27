package com.hrms.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.hrms.business.abstracts.EmployerService;
import com.hrms.hrms.business.constant.Messages;
import com.hrms.hrms.core.utilities.business.BusinessRules;
import com.hrms.hrms.core.utilities.results.DataResult;
import com.hrms.hrms.core.utilities.results.ErrorResult;
import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.core.utilities.results.SuccessDataResult;
import com.hrms.hrms.core.utilities.results.SuccessResult;
import com.hrms.hrms.dataAccess.abstracts.EmployerDao;
import com.hrms.hrms.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService {

	private EmployerDao employerDao;
	
	@Autowired
	public EmployerManager(EmployerDao employerDao) {
		this.employerDao = employerDao;
	}
	
	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll());
	}

	@Override
	public Result add(Employer employer, String repeatPassword) {
		Result result = BusinessRules.Run(
				domainCheck(employer.getEmail(), employer.getWebSite()),
				checkIfPassword(employer.getPassword(), repeatPassword),
				checkIfEmail(employer.getEmail())
				);
		
		if (result != null) {
			return result;
		}
		
		this.employerDao.save(employer);
		return new SuccessResult();
	}
	
	private Result domainCheck(String email, String website) {
		if (!email.equals(website)) {
			return new ErrorResult("aaaa");
		}
		return new SuccessResult();
	}
	
	private Result checkIfPassword(String password, String repeatPassword) {
		if (!password.equals(repeatPassword)) {
			return new ErrorResult(Messages.passwordUnmatch);
		}
		return new SuccessResult();
	}
	
	private Result checkIfEmail(String email) {
		for (Employer employer : this.employerDao.findAll()) {
			if (employer.getEmail().equals(email)) {
				return new ErrorResult("dflklşsfd");
			}
		}		
		return new SuccessResult();
	}



}
