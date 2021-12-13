package com.hrms.hrms.business.abstracts;

import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.entities.concretes.Contact;

public interface ContactService {
	Result add(Contact contact);
}
