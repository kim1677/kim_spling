package com.movieAndgame.control;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.movieAndgame.Dto.GameMember;
import com.movieAndgame.Service.GameMemberService;

@Controller
@RequestMapping("/game")
public class GameController {
	
	@Autowired
	private GameMemberService gameMemberService;
	
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
		model.addAttribute("gameMember", new GameMember());
		return "game/member/join";
	}
	
	// 회원가입 후 요청
	@PostMapping("/signUp")
	public String singUp(@Valid GameMember gameMember, BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors()) {
			return "game/member/join";
		}
		
		gameMemberService.signUpsave(gameMember);
		
		return "redirect:/game/login";
	}
}
