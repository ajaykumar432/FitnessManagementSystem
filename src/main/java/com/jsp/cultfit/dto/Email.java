package com.jsp.cultfit.dto;

import lombok.Data;

@Data

public class Email {
	private String to;
	private String subject;
	private String body;
	private String attachment;
}
