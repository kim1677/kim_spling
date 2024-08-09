package com.example.bookTest.CoffeControl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@GetMapping("/coffe/view")
	public ModelAndView view(@RequestParam(value="id", required=false, defaultValue="0") int id) {
		
		CoffeDto dto = coffeService.getCoffe(id);
		if(dto == null) dto = new CoffeDto();	// getBook메서드의 반환값으로 null 저장된다면 view.jsp에서 변수의 값이 null이기 때문에 get 메서드 호출이 안되어 오류가 발생한다.
												// 오류가 발생되지 않게 하기위해 빈 값이 있는 객체 할당
		return new ModelAndView("coffe/view").addObject("coffe", dto);
		
	}
	
	@GetMapping("/coffe/delete")
	public String coffeRemove(@RequestParam("id") int bid) {
		coffeService.remove(bid);
		return "redirect:/coffe";
	}
	
//	@GetMapping("/coffe/view")
//	public ModelAndView view(@RequestParam("id") int id) {
//		CoffeDto dto = coffeService.getCoffe(id);
//		return new ModelAndView("coffe/view").addObject("coffe", dto);
//	}
	
}
