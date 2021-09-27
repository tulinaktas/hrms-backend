package com.hrms.hrms.business.abstracts;

import java.util.List;

import com.hrms.hrms.core.utilities.results.DataResult;
import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.entities.concretes.Candidate;

public interface CandidateService {
	Result add(Candidate candidate, String repeatPassword);
	DataResult<List<Candidate>> getAll();
}
