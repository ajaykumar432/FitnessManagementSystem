package com.jsp.cultfit.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Image {
	private int id;
	private String name;
	@Lob
	@Column(columnDefinition = "LONGBLOB", length = 9999999)
	private byte[] data;

}
