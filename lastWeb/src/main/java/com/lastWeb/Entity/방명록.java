package com.lastWeb.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Inheritance
public class 방명록 {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;	// 테이블에는 하나이상의 기본키(primary key) 존재해야한다. 테이블의 대표값이다.
						// 일반적으로 테이블의 primart key를 id로 한다.
	private String userName;
	private String detail;

}
