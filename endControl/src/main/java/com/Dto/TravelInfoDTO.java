package com.Dto;

import lombok.Getter;
import lombok.Setter;

@Setter	// Model attribute에 저장하기 위해 사용
@Getter
public class TravelInfoDTO {		// 화면(뷰페이지) 출력을 위한 클래스
	private int travelId;
	private int ticketPrice; 		// 항공권 금액
	private String travelPackage;	// 여행 패키지
	
}
