package com.myService.Control;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.myService.DTO.BestFoodDto;
import com.myService.Service.FoodService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MyController {

	private final FoodService foodService;
	
	@GetMapping("/food")
	public String home(){
		return "food";
	}
	
	@GetMapping("/bestfood")
	public String bestfood(Model model) {
		List<BestFoodDto> list = foodService.getFoods();
		model.addAttribute("foodlist", list);
		return "bestfood";
	}

	
	
}
