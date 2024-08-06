package com.example.test1.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.test1.DTO.BoardDto;

@Controller
public class BoardController {
	
	@GetMapping("/board")
	public ModelAndView boardHome() {
		ModelAndView mav =  new ModelAndView();
		mav.setViewName("board/boardList");
		return mav;
	}
	
	@GetMapping("/boardWrite")
	public String boardwrite() {
		return "board/write";
	}
	
	@PostMapping("/write")
	public ModelAndView write(@ModelAttribute BoardDto boardDto) {
		ModelAndView mv = new ModelAndView("board/view");
		mv.addObject("data", boardDto);
		return mv;
	}
	
	
}
