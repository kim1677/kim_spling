package com.lastWeb;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.lastWeb.Dto.방명록Dto;
import com.lastWeb.Service.Service방명록;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MainController {

	private final Service방명록 service방명록;
	
	@GetMapping("/")
	public String main() {
		return "index";
	}
	
	@PostMapping("/save")
	public String save(@ModelAttribute 방명록Dto dto, Model model) {	
		service방명록.방명록저장(dto);
		List<방명록Dto> dtos = service방명록.getDatas();
		model.addAttribute("dtos", dtos);
		return "list";
	}
	
}

// 뷰페이지에서 받은 데이터를 데이터베이스에 저장한다.
// 컨트롤에서 받아 Dto에 저장하고 컨트롤에서 서비스에게 넘겨준다.
// 서비스에서 Dto에 담겨있는 데이터를 entity로 바꿔주고 레포지토리를 통해 save 한다.