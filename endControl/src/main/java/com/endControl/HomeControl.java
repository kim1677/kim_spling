package com.endControl;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeControl {
	
	@GetMapping("/home")
	public String myhome(Model model) {
		model.addAttribute("myName", "김철수");
		return "home";
		
	}
	
	@GetMapping("/myFriend")
	public String friend() {
		return "friendWrite";
	}
	
	@PostMapping("/friendInput")
	public String input(@ModelAttribute Friend friend, Model model) {
		model.addAttribute("friend", friend);
		return "myFriendinfo";
	}
}
