package com.myService.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BestFoodDto {
	
	private	String foodName;
	
	// 클래스 메서드 생성 및 호출
	public static BestFoodDto of(String food) {		// of : DTO 객체를 생성하기 위한 메서드
		BestFoodDto bestFoodDto = new BestFoodDto();
		bestFoodDto.setFoodName(food);
		return bestFoodDto;
	}

}
