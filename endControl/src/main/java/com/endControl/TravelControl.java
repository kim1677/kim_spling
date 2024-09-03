package com.endControl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.Dto.TravelDestDTO;
import com.Dto.TravelInfoDTO;
import com.endControl.Service.TravelService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class TravelControl {
	// 메서드 호출.1
	// @Autowired, final : 필요한 객체를 프레임워크가 알아서 만들어줌
	// 단 둘을 같이 섞어서 사용하는 건 삼가해야 함
	
//	@Autowired(간단한 작업을 할때만 이용)
//	private TravelService travelService;
	
	// 생성자 메서드 호출.2(가장 권장하는 방식)
	private final TravelService travelService;
	
	@GetMapping("/travel")
	public String home(Model model) {
		model.addAttribute("myId", "sky");
		// model은 컨트롤에서 뷰로 데이터를 전달하기 위한 용도
		// DTO는 사용자 요청과 응답에 사용된다. 
			// 사용자가 쓰는 메서드
			// 사용자가 입력한 데이터를 저장하기도 하고
			// 사용자 화면(뷰페이지)에 데이터를 출력하기 위한 용도
		// Service는 컨트롤과 데이터베이스 사이에서 동작 사용자가 이용한 DTO도 필요
		return "main";
	}
	
	@PostMapping("/search")
	public String input(@ModelAttribute TravelDestDTO travelDestDTO, Model model){
		// 입력한 여행지 TravelDestDTO 클래스 객채에 저장했다.
		// 여행지에 맞는 항공권과 여행패키지에 대한 정보를 사용자에게 보여줘야 한다.
		// 사용자가 넘겨준 데이터가 아닌 다른 데이터는 Service를 통해서 에서 가져온다.  
		
		// 객체를 만들어서 메서드 호출 - 이런 방식은 일일이 넣어야 하기 때문에 번거로움
//		TravelService travelService = new TravelService();
//		travelService.test();
		
		// 내가 입력한 여행지는 travelDestDTOdp 저장되어 있다.
		TravelInfoDTO info = travelService.travelSearch(travelDestDTO);
		model.addAttribute("info", info);
		return "result";
	}
}

/*
  		여행지를 입력 한다.
  		입력한 여행지의 항공권 금액과 패키지에 대해 출력
  		DTO - 여행지, 항공권, 패키지 저장용
  			- 여행지 입력 : TravelDestDTO
  			- 항공원, 패키지 : TravelInfoDTO
 
 */
