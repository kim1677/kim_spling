package com.movieAndgame.control;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.movieAndgame.Dto.GameMember;
import com.movieAndgame.Dto.GameReviewDto;
import com.movieAndgame.Service.GameReviewService;

@Controller
@RequestMapping("/gameMenu")
public class GameMenuControl {
	
	@Autowired
	private GameReviewService reviewService;
	
	@GetMapping("/write")
	public String reviewWrite(@Valid GameReviewDto gameReviewDto, BindingResult bind, Model model) {
		if(bind.hasErrors()) {
			return "game/gameMenu/review";
		}
		reviewService.save(gameReviewDto);
		return "redirect:/gameMenu/review";
	}

	@GetMapping("/review")
	public String reviewMain(Model model) {
		return "game/review/index";
	}
	
	@GetMapping("/reviewWrite")
	public String write(Model model, HttpSession session) {
		if(session.getAttribute("user")==null)	{	// 로그인 상태가 아니면 로그인 페이지 이동
			return "redirect:/game/login";
		}
		
		GameReviewDto dto = new GameReviewDto();
		String name = ((GameMember)session.getAttribute("user")).getUsername();
		dto.setWriter(name);
		
		model.addAttribute("gameReviewDto", dto);
		
		return "game/review/write";
	}
	
}

