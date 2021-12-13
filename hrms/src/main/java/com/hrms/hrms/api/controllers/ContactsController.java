package com.hrms.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hrms.hrms.business.abstracts.ContactService;
import com.hrms.hrms.core.utilities.results.Result;
import com.hrms.hrms.entities.concretes.Contact;

@RequestMapping("/api/contacts")
@RestController
public class ContactsController {

	private ContactService contactService;

	@Autowired
	public ContactsController(ContactService contactService) {
		this.contactService = contactService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Contact contact) {
		return this.contactService.add(contact);
	}
	
	
	
}
