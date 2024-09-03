package com.endControl;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.Dto.MyLunch;

@Controller	// 페이지 맵핑 필수
public class Control {
	
	@GetMapping("/")
	public String home() {
		return "index";
	}
	
	@GetMapping("/lunch")
	public String lunch() {;
		return "lunch";
	}
	
	@GetMapping("/lunchinput")
	public String lunchput(@ModelAttribute MyLunch mylunch, Model model) {
		model.addAttribute("myLunch", mylunch);
		return "index";
	}

}
