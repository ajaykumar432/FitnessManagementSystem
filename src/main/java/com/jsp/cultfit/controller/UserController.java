package com.jsp.cultfit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.cultfit.dto.Register;
import com.jsp.cultfit.dto.UserClone;
import com.jsp.cultfit.entity.User;
import com.jsp.cultfit.service.UserService;
import com.jsp.cultfit.util.ResponseStructure;

import jakarta.mail.MessagingException;

@RestController
public class UserController {

	@Autowired
	UserService service;
	
	@PostMapping("/user/save")
	public ResponseEntity<ResponseStructure<Register>> saveUser(@RequestBody Register register) throws MessagingException {
		return service.saveUser(register);
	}
	
	@PostMapping("/user/login")
	public ResponseEntity<ResponseStructure<UserClone>> loginUser(@RequestParam String email,@RequestParam String password){
		return service.loginUser(email, password);
	}
	
	@PostMapping("/user/fetch")
	public ResponseEntity<ResponseStructure<UserClone>> fetchUser(@RequestParam int id){
		return service.fetchUser(id);
	}
	
	@PostMapping("/user/delete")
	public ResponseEntity<ResponseStructure<UserClone>> deleteUser(@RequestParam int id){
		return service.deleteUser(id);
	}
	
	@PostMapping("/user/update")
	public ResponseEntity<ResponseStructure<User>> updateUser(@RequestBody User user){
		return service.updateUser(user);
	}
	
	
}
