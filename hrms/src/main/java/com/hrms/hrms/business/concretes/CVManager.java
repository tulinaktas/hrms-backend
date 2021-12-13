/*package com.hrms.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.hrms.business.abstracts.CVService;
import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.core.utilities.results.SuccessResult;
import com.hrms.hrms.dataAccess.abstracts.CVDao;
import com.hrms.hrms.entities.concretes.CV;

@Service
public class CVManager implements CVService{

	private CVDao cvDao;
	
	@Autowired
	public CVManager(CVDao cvDao) {
		this.cvDao = cvDao;
	}

	@Override
	public Result add(CV cv) {
		this.cvDao.save(cv);
		return new SuccessResult();
	}

}
*/