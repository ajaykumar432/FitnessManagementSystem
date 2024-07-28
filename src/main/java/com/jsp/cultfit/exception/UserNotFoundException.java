package com.jsp.cultfit.exception;

import lombok.Data;

@Data
public class UserNotFoundException extends RuntimeException{
	private String msg="User Not Found"; 
}
