package com.jsp.cultfit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.jsp.cultfit.service.UserService;


	@RestController
	public class UserEmail {
		@Autowired
		UserService service;
		
		@GetMapping("/mail")
		public void sendEmail(@RequestBody String email) {
			System.out.println(email);
	    	service.sendMsg(email);
		} 

}
