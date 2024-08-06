package com.example.test1.DTO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter		// Spling Get 메서드 생성
@Setter		// Spling Set 메서드 생성
@ToString	// Spling ToString 메서드 생성
public class MemberDto {
	private String id;
	private String pw;
	private String tel;
	private String birth;
	

}
