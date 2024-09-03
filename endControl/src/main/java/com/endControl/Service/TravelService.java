package com.endControl.Service;

import org.springframework.stereotype.Service;

import com.Dto.TravelDestDTO;
import com.Dto.TravelInfoDTO;


@Service
public class TravelService {
	
	// 여행지에 맞는 항공권과 패키지 찾기
	public TravelInfoDTO travelSearch(TravelDestDTO travelDestDto){		// 데이터베이스에서 가져온 DTO를 뷰 화면 DTO로 전달
		// 데이터페이스에서 조회하여 입력한 여행지와 일치하는 데이터 찾아서 가져오기
		TravelInfoDTO travelInfoDTO = new TravelInfoDTO();
		travelInfoDTO.setTravelId(10);
		travelInfoDTO.setTicketPrice(1677600);
		travelInfoDTO.setTravelPackage("룩셈부르크 7박4일 무제한바 패키지");
		
		return travelInfoDTO;
	}
	
	public void test() {
		System.out.println("서비스 클래스 테스트");
	}
	
	// 호출 2가지 방식
	// 서비스 클래스에 static을 만들어서 호출  - 스프링은 static을 허용하지 않음
	// 객체를 만들어서 객체를 통한 호출		   - 스프링은 객체를 통한 메서드를 권장함
	
}
