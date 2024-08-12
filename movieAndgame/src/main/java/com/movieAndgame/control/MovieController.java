package com.movieAndgame.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.movieAndgame.control.Dto.MovieMember;

@Controller
@RequestMapping("/movie")
public class MovieController {

	// "/" 은 localhost/movie 맵핑이다.
	@GetMapping("/index")
	public String Home(Model model) {
		return "movie/index";
	}
	
	@GetMapping("/login")
	public String loginHome(Model model) { // loginHome 메서드에 Model 객체를 파라미터로 받고 반환 
 		model.addAttribute("member", new MovieMember() );	// member를 사용해 MovieMember 객체를 뷰에 전달
		return "movie/member/login";	// login 경로로 메서드 반환
	}
}
