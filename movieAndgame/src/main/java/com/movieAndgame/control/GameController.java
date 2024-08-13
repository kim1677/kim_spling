package com.movieAndgame.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.movieAndgame.control.Dto.GameMember;
import com.movieAndgame.control.Dto.MovieMember;

@Controller
@RequestMapping("/game")
public class GameController {
	
	// localhost/game/index 맵핑
	@GetMapping("/index")
	public String Home(Model model) {
		return "game/index";
	}
	
	// 로그인 페이지 요청
	@GetMapping("/login")
	public String loginHome(Model model) {
		model.addAttribute("gameMember", new GameMember() );
		return "game/member/login";
	}
	
	// 회원가입 페이지 요청
	@GetMapping("/signUp")
	public String signUp(Model model) {
		return "game/member/join";
	}
}
