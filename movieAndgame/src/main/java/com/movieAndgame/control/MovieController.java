package com.movieAndgame.control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
	
	// 인덱스 페이지 요청
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
	
	// 회원가입 작성 후 요청(유효성 검사)
	@PostMapping("/signUp")
	public String signUp(@Valid MovieMember movieMember, BindingResult bindingResult, Model model ) {
		if( bindingResult.hasErrors()) {	// 에러 발생시 bindingResult에서 받음
			System.out.println("유효하지 않은값이 입력되었다.");
			return "movie/member/join";		// 로그인 실패시 model로 담아서 회원가입 페이지로 되돌림
		}
		
		boolean isDup = movieMemberService.signUpsave(movieMember);
		if(isDup) {	// 이메일이 중복이라면 회원가입 페이지로 이동시킨다.
			bindingResult.rejectValue("email", "error.email", "가입된 이메일입니다.");
			return "/movie/member/join";
		}
		
		return "redirect:/movie/login";
	}
	
	// 로그인 처리 후 요청
	@PostMapping("/signIn")
	public String signIn(MovieMember member, HttpSession sesstion, Model model) {
		// 로그인 처리 - 데이터베이스에 이메일과 비번이 일치하는지 확인
		// 일치하면 세션 만들고 첫페이지로 이동, 일치하지 않으면 로그인 페이지로 돌려보내기
		MovieMember user = movieMemberService.login(member);
		if(user==null) { //로그인 실패(이메일 또는 비밀번호 잘못 입력)
			model.addAttribute("member", member);	// member 객체로 보내는 것
			model.addAttribute("fail", "a" );
			return "/movie/member/login";
		}
		sesstion.setAttribute("user", user);
		
		return "redirect:/movie/index";
	}
	
	// 로그아웃 요청
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("user");
		return "redirect:/movie/index";
	}
}
