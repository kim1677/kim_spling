package com.movieAndgame.control;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.movieAndgame.Dto.MovieMember;
import com.movieAndgame.Dto.MovieReviewDto;
import com.movieAndgame.Service.MovieReviewService;

@Controller
@RequestMapping("/movieMenu")
public class MovieMenuControl {
	
	@Autowired
	private MovieReviewService reviewService;
	
	// 글 내용작성 후 저장 요청
	@GetMapping("/write")
	public String reviewWrite(@Valid MovieReviewDto movieReviewDto, BindingResult bind, Model model) {
		if(bind.hasErrors()) {
			return "movie/review/write";
		}
		reviewService.save(movieReviewDto);
		return "redirect:/movieMenu/review";
	}
		
	@GetMapping("/review")
	public String reviewMain(Model model) {
		return "movie/review/index";
	}
	
	// 리뷰작성 페이지 요청
	@GetMapping("/reviewWrite")
	public String write(Model model, HttpSession session) {
		if(session.getAttribute("user")==null)	{	// 로그인 상태가 아니면 로그인 페이지 이동
			return "redirect:/movie/login";
		}
		
		MovieReviewDto dto = new MovieReviewDto();
		String name = ((MovieMember)session.getAttribute("user")).getName();
		dto.setWriter(name);
		
		model.addAttribute("movieReviewDto", dto);
		
		return "movie/review/write";
	}
}
