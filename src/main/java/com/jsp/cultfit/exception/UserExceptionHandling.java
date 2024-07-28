package com.jsp.cultfit.exception;

import java.sql.SQLIntegrityConstraintViolationException;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.jsp.cultfit.util.ResponseStructure;

import jakarta.mail.MessagingException;

@RestControllerAdvice
public class UserExceptionHandling {

	@ExceptionHandler(SQLIntegrityConstraintViolationException.class)
	public ResponseEntity<ResponseStructure<String>> duplicateUser(SQLIntegrityConstraintViolationException e)
			throws MessagingException {

		ResponseStructure<String> res = new ResponseStructure<String>();
		res.setData("Duplicate Entry");
		res.setMessage("User Data Duplicate Entry...");
		res.setStatus(HttpStatus.NOT_ACCEPTABLE.value());
		res.setDate(LocalDateTime.now());
		return new ResponseEntity<ResponseStructure<String>>(res, HttpStatus.NOT_ACCEPTABLE);

	}
	
	@ExceptionHandler(PasswordWrongException.class)
	public ResponseEntity<ResponseStructure<String>> wrongPassword(PasswordWrongException e) throws MessagingException {
		ResponseStructure<String> res = new ResponseStructure<String>();
		res.setData("Wrong password");
		res.setMessage("Please enter correct password...");
		res.setStatus(HttpStatus.UNAUTHORIZED.value());
		res.setDate(LocalDateTime.now());
		return new ResponseEntity<ResponseStructure<String>>(res, HttpStatus.UNAUTHORIZED);

	}
	
	@ExceptionHandler(EmailNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> emailNotFound(EmailNotFoundException e) throws MessagingException {
		ResponseStructure<String> res = new ResponseStructure<String>();
		res.setData("Email Not Found");
		res.setMessage("Please register .....");
		res.setStatus(HttpStatus.NOT_FOUND.value());
		res.setDate(LocalDateTime.now());
		return new ResponseEntity<ResponseStructure<String>>(res, HttpStatus.NOT_FOUND);

	}
	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> userNotFound(UserNotFoundException e) throws MessagingException {
		ResponseStructure<String> res = new ResponseStructure<String>();
		res.setData("Data Not Found");
		res.setMessage("Please register .....");
		res.setStatus(HttpStatus.NOT_FOUND.value());
		res.setDate(LocalDateTime.now());
		return new ResponseEntity<ResponseStructure<String>>(res, HttpStatus.NOT_FOUND);

	}
	
}
