package com.movieAndgame.control;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.movieAndgame.Dto.GameMember;
import com.movieAndgame.Dto.GameReviewDto;
import com.movieAndgame.Service.GameReviewService;

@Controller
@RequestMapping("/gameReview")
public class GameMenuControl {
	
	@Autowired
	private GameReviewService reviewService;
	
	@PostMapping("/write")
	public String reviewWrite(@Valid GameReviewDto gameReviewDto, BindingResult bind, Model model) {
		if(bind.hasErrors()) {
			return "game/review/write";
		}
		reviewService.save(gameReviewDto);
		return "redirect:/gameReview/moblie";
	}
	
	@GetMapping("/mobile")
	public String index(Model model) {
		
		List<GameReviewDto> list = reviewService.reviewlist();
		model.addAttribute("reviewList", list);
	
		return "game/review/index";
	}
	
	@GetMapping("/write")
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
	
	@GetMapping("/view/{id}")
	public String view(@PathVariable("id") int id, Model model) {
		
		GameReviewDto dto = reviewService.findById(id);
		model.addAttribute("gameReviewDto", dto);
		
		return "game/review/detail";
	}
	
}

