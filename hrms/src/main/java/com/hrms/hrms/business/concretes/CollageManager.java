package com.hrms.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.hrms.hrms.business.abstracts.CollageService;
import com.hrms.hrms.core.utilities.results.DataResult;
import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.core.utilities.results.SuccessDataResult;
import com.hrms.hrms.core.utilities.results.SuccessResult;
import com.hrms.hrms.dataAccess.abstracts.CollageDao;
import com.hrms.hrms.entities.concretes.Collage;

@Service
public class CollageManager implements CollageService{

	private CollageDao collageDao;
	
	@Autowired
	public CollageManager(CollageDao collageDao) {
		this.collageDao = collageDao;
	}
	
	@Override
	public DataResult<List<Collage>> getByAllCollageByYear() {
		Sort sort = Sort.by(Sort.Direction.DESC, "dueDate");
		return new SuccessDataResult<List<Collage>>(this.collageDao.findAll(sort));
	}

	@Override
	public Result add(Collage collage) {
		this.collageDao.save(collage);
		return new SuccessResult();
	}
}
