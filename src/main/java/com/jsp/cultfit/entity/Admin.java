package com.jsp.cultfit.entity;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Admin {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int id;
	private String fname;
	private String lname;
	@Column(unique = true)
	private String email;
	private String pwd;
	private String gender;
	private Date dob;
	@Column(unique = true)
	private long phone;

}
