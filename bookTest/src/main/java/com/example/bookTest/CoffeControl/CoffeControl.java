package com.example.bookTest.CoffeControl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.bookTest.CoffeService.CoffeService;
import com.example.bookTest.Dto.BookDto;
import com.example.bookTest.Dto.CoffeDto;

@Controller
public class CoffeControl {
	@Autowired
	private CoffeService coffeService;
	
	@GetMapping("/coffe")
	public ModelAndView home() {
		ModelAndView cf = new ModelAndView("coffe/index");
		
		List<CoffeDto> list = coffeService.selectAll();
		cf.addObject("list", list);
		
		return cf;
	}
	
	@GetMapping("/coffeReg")
	public String coffereg() {
		return "coffe/coffeForm";
	}
	
	@PostMapping("/coffesave")
	public String write(@ModelAttribute CoffeDto coffeDto) {
		// form태그안에 입력한 값은 BookDto클래스의 객체에 저장되어 있다.
		// 데이터베이스에 저장하려면 BookDto객체를 DAO에 넘겨서 저장하면된다.
		// 컨트롤 → service → DAO
		coffeService.coffeSave(coffeDto);
		
		return "redirect:/coffe";
	}
	
}
