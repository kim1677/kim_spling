package com.mydata;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainControl {
	
	@GetMapping("/index")
	public String index() {
		return "/mainPage";
	}
	
	@GetMapping("/info")
	public String info() {
		return "/info";
	
	}
	
	
	// MVC(Model View Control) 패턴 이용
	@GetMapping("infosave")	// infodave : 파리미터를 받아주기 위해 메서드 
	public String save(@RequestParam("name") String name, @RequestParam("age") int age, @RequestParam("birth") String birth, Model model) {
		model.addAttribute("myName", name );
		model.addAttribute("myage", age );
		model.addAttribute("mybirth", birth );
		return "mainPage";	// 서버에 요청 후 다시 mainPage로 반환
	}
	
	@GetMapping("/favorite")
	public String fv() {	
		return "myFavorite";
	}
	
	@PostMapping("/send")
	public String send(@RequestParam("movie") String movie, @RequestParam("sports") String sports, @RequestParam("music") String music, Model model ) {	// Dto 객체를 사용하지 않으면 @RequestParam 사용
		model.addAttribute("mymovie", movie );
		model.addAttribute("mysports", sports );
		model.addAttribute("mymusic", music );
		return "result";
	}
	
}
