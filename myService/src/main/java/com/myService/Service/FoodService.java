package com.myService.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.myService.DTO.BestFoodDto;

@Service
public class FoodService {
	public List<BestFoodDto> getFoods() {
		
		List<BestFoodDto> bestFoodDtoList = new ArrayList<>();
		// ArrayList 객체를 생성
		BestFoodDto bestFoodDto = new BestFoodDto();
		bestFoodDto.setFoodName("파전");
		bestFoodDtoList.add(bestFoodDto);
			// 데이터 한개당 여기까지 써야하므로 비추천
		
		// DTO에 있는 클래스 메서드로 가져오기
		bestFoodDtoList.add(BestFoodDto.of("김치찌개"));
		bestFoodDtoList.add(BestFoodDto.of("고추장불고기"));
		bestFoodDtoList.add(BestFoodDto.of("육개장"));
		bestFoodDtoList.add(BestFoodDto.of("치마살"));
		
		return bestFoodDtoList;
	}
	
}

