package com.hrms.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.hrms.adapters.CandidateUserCheckService;
import com.hrms.hrms.adapters.MernisServiceAdapter;
import com.hrms.hrms.business.abstracts.CandidateService;
import com.hrms.hrms.business.constant.Messages;
import com.hrms.hrms.core.utilities.business.BusinessRules;
import com.hrms.hrms.core.utilities.results.DataResult;
import com.hrms.hrms.core.utilities.results.ErrorResult;
import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.core.utilities.results.SuccessDataResult;
import com.hrms.hrms.core.utilities.results.SuccessResult;
import com.hrms.hrms.dataAccess.abstracts.CandidateDao;
import com.hrms.hrms.entities.concretes.Candidate;

@Service
public class CandidateManager implements CandidateService
{
	private CandidateDao candidateDao;
	private CandidateUserCheckService candidateUserCheckService;
	
	@Autowired
	public CandidateManager(CandidateDao candidateDao) {
		this.candidateDao = candidateDao;
		this.candidateUserCheckService = new MernisServiceAdapter();	
	}
	
	public DataResult<List<Candidate>> getAll() {
		return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAll());
		}

	@Override
	public Result add(Candidate candidate, String repeatPassword) {
		
		Result result = BusinessRules.Run(
				checkIfEmailOrIdentityNumber(candidate.getEmail(),candidate.getIdentityNumber()), 
				mernisCheck(candidate),
				checkIfPassword(candidate.getPassword(), repeatPassword)
				);
		
		if (result != null) {
			return result;
		}
		
		this.candidateDao.save(candidate);
		return new SuccessResult(Messages.candidateAdd);
	}
	
	private Result checkIfEmailOrIdentityNumber(String email, String identityNumber) {
		for (Candidate candidate : this.candidateDao.findAll() ) {
			if (candidate.getEmail().equals(email)|| candidate.getIdentityNumber().equals(identityNumber)) {
				return new ErrorResult(Messages.emailOrIdendityNumberIsInvalid);
			}
		}
		return new SuccessResult();
	}
	
	private Result mernisCheck(Candidate candidate) {
		
		if(!this.candidateUserCheckService.checkRealPerson(candidate)) {
			return new ErrorResult(Messages.mernisCheckIsNotOk);
		}
		return new SuccessResult();
	}
	
	private Result checkIfPassword(String password, String repeatPassword) {
		if (!password.equals(repeatPassword)) {
			return new ErrorResult(Messages.passwordUnmatch);
		}
		return new SuccessResult();
	}

}
