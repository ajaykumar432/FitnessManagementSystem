package com.jsp.cultfit.entity;

import java.sql.Date;
import java.sql.Time;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
public class Attendence {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private int id;
	private double hour;
	private Date date;
	private Time time;
	private double weight;

}
