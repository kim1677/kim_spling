package com.movieAndgame.control;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.movieAndgame.Dto.TestMember;

@Controller
public class TestController {
	
	// 페이지 보여주기 위한 맵핑
	@GetMapping("/test")
	public String testHome(Model model) {
		TestMember mem = new TestMember();	// 객체 생성
		mem.setAge(25);
		mem.setEmail("rudwpww@naver.com");
		mem.setName("이순신");
		mem.setTel("010-9634-7931");
		
		String name = "이순신";
		
		List<String> animal = new ArrayList<>();
		animal.add("사자"); animal.add("개"); animal.add("고양이"); animal.add("호랑이"); animal.add("코끼리");
		
		// 매개변수를 메서드에 담아서 뷰로 전달
		model.addAttribute("tag","<h1>타임리프</h1>");
		model.addAttribute("name", name);
		model.addAttribute("member", mem);
		model.addAttribute("animal", animal);
		
		return "test";
	}
}
