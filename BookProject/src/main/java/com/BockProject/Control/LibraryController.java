package com.BockProject.Control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.BockProject.DTO.BkDTO;

@Controller
public class LibraryController {
	
	@GetMapping("index")
	public String index(){
		return "index";
	}
	
	@GetMapping("login")
	public String login(){
		return "login";
	}
	
	@GetMapping("bookindex")
	public String book(){
		return "book/bookindex";
	}
	
	@GetMapping("search")
	public String search(){
		return "/book/search";
	}
	
	@GetMapping("write")
	public String write(){
		return "/book/write";
	}
	
	@GetMapping("view")
	public String view( ){
		return "/book/view";
	}

}
