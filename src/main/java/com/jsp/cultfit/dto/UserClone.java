package com.jsp.cultfit.dto;

import lombok.Data;

@Data
public class UserClone {
	private int id;
	private String f_name;
	private String l_name;
	private String email;
	private String gender;
	private long phonenumber;
	private java.sql.Date dateofbirth;
}
