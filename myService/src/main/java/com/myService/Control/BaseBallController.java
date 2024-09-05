package com.myService.Control;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.myService.DTO.PitcherDto;
import com.myService.Service.BaseBallService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class BaseBallController {
	
	private final BaseBallService ballservice;
	
	@GetMapping("/")
	public String main() {
		return "main";
	}
	
	@GetMapping("/bbsearch")
	public String search(@ModelAttribute PitcherDto pitcherDto, Model model) {
		List<PitcherDto> list = ballservice.searchPitcher(pitcherDto);
		
		model.addAttribute("pitcherList", list);
//		model.addAttribute("pitcher", pitcherDto);
		return "pitcherinfo";
	}
	
}
