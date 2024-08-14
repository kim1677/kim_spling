package com.movieAndgame.control;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.movieAndgame.Dto.MovieMember;
import com.movieAndgame.Service.MovieMemberService;

@Controller
@RequestMapping("/movie")
public class MovieController {

	// "/" 은 localhost/movie 맵핑이다.
	
	@Autowired
	private MovieMemberService movieMemberService;
	
	@GetMapping("/index")
	public String Home(Model model) {
		return "movie/index";
	}
	
	// 로그인 페이지 요청
	@GetMapping("/login")
	public String loginHome(Model model) { // loginHome 메서드에 Model 객체를 파라미터로 받고 반환 
 		model.addAttribute("member", new MovieMember() );	// member를 사용해 MovieMember 객체를 뷰에 전달
		return "movie/member/login";	// login 경로로 메서드 반환
	}
	
	// 회원가입 페이지 요청
	@GetMapping("/signUp")
	public String signUp(Model model) {
		model.addAttribute("movieMember", new MovieMember());
		return "movie/member/join";
	}
	
	// 회원가입 작성 후 요청
	@PostMapping("/signUp")
	public String signUp(@Valid MovieMember movieMember, BindingResult bindingResult, Model model ) {
		if( bindingResult.hasErrors()) {	// 에러 발생시 bindingResult에서 받음
			System.out.println("유효하지 않은값이 입력되었다.");
			return "movie/member/join";		// 로그인 실패시 model로 담아서 회원가입 페이지로 되돌림
		}
		
		movieMemberService.signUpsave(movieMember);
		
		return "redirect:/movie/login";
	}
	
}
