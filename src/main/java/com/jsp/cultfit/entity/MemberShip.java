package com.jsp.cultfit.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class MemberShip {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int height;
	private double weight;
	private int age;
	private String gender;
	private  MemberShip type;
	private double bodyfat;
	@OneToOne
	private Payment payment;
	@OneToMany
	private List<Attendence> attendence;
	@ManyToOne
	private Trainer trainer;
	

}
