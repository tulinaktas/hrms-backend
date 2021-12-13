package com.hrms.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.hrms.business.abstracts.ContactService;
import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.core.utilities.results.SuccessResult;
import com.hrms.hrms.dataAccess.abstracts.ContactDao;
import com.hrms.hrms.entities.concretes.Contact;

@Service
public class ContactManager implements ContactService {

	private ContactDao contactDao;

	@Autowired
	public ContactManager(ContactDao contactDao) {
		this.contactDao = contactDao;
	}

	@Override
	public Result add(Contact contact) {
		this.contactDao.save(contact);
		return new SuccessResult();
	}
	
}
