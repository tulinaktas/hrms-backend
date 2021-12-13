package com.hrms.hrms.business.abstracts;

import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.entities.concretes.Skill;

public interface SkillService {
	Result add(Skill skill);
}
