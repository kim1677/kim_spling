package com.myService.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PitcherDto {	// DTO는 화면에 어떤 내용을 보여줄지 생각하고 만들어야 함
	private String name;				// 이름
	private int lostpoint;				// 실점
	private int strikeOut;			// 탈삼진
	private float avgEarnedRun;			// 평균자책점
	
	
	//
	public static PitcherDto of(String name, int lp, int so, float aer) {
		PitcherDto pitcherDto = new PitcherDto();
		pitcherDto.setName(name);
		pitcherDto.setLostpoint(72);
		pitcherDto.setAvgEarnedRun(aer);
		pitcherDto.setStrikeOut(so);
		
		return pitcherDto;
	}
	
}
