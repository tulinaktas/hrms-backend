package com.hrms.hrms.adapters;

import com.hrms.hrms.entities.concretes.Candidate;

public interface CandidateUserCheckService {
	
	boolean checkRealPerson(Candidate candidate);
	
}
