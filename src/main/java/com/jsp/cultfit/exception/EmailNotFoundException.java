package com.jsp.cultfit.exception;

import lombok.Data;

@Data

public class EmailNotFoundException extends RuntimeException{
	private String msg="Email Not found";
}
