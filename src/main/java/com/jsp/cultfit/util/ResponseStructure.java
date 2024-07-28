package com.jsp.cultfit.util;

import java.time.LocalDateTime;
import java.util.List;

import com.jsp.cultfit.entity.User;

import lombok.Data;

@Data
public class ResponseStructure<T> {
	
	private int status;
	private T data;
	private String message;
	private LocalDateTime date;
	//private List<User> datalist;

}