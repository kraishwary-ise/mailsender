package com.example.mailsender.mailsender;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmailData {
	private Integer id;
	private String email;
	private String body;
	private String from;
	private String to;
	private String subject;
}
