package com.movieAndgame.control.Dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MovieMember {
	private String email;
	private String password;
	private String name;
	private int birthYear;
	private int birthMonth;
	private String tel;
}
