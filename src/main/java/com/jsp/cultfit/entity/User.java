package com.jsp.cultfit.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String f_name;
	private String l_name;
	@Column(unique = true)
	private String email;
	private String password;
	private String gender;
	@Column(unique = true)
	private long phonenumber;
	private java.sql.Date dateofbirth;
	private List <MemberShip>  membership;
}