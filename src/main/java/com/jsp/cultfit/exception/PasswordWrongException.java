package com.jsp.cultfit.exception;

import lombok.Data;

@Data
public class PasswordWrongException extends RuntimeException{
	public String msg="Password Incorrect";
}
