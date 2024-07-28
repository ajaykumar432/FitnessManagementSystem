package com.jsp.cultfit.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;

import com.jsp.cultfit.dao.AdminCrud;

public class AdminService {
	@Autowired
	AdminCrud crud;
	@Autowired
	ModelMapper mapper;
	@Autowired
	JavaMailSender mail;
	
	public ResponseEntity<ResponseStructure<Register>> adminSave(Registe register){
		crud.save(admin);
		
	}

}
