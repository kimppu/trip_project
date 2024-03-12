package com.example.travelproject.domain.user.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardDto {
	
	private int num;
	private String name;
	private String pwd;
	private String email;
	private String subject;
	private String content;
	private String ipAddr;
	private String created;
	private int hitCount;

}