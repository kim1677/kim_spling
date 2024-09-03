package com.endControl;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.Dto.ToyDestDTO;
import com.Dto.ToyInfoDTO;
import com.endControl.Service.ToyService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ToyControl {
	
	private final ToyService toyService;

	@GetMapping("/toy")
	public String home(Model model) {
		model.addAttribute("toyId", "name");
		return "toymain";
	}
	
	@PostMapping("/toysearch")
	public String toyinput(@ModelAttribute ToyDestDTO toyDestDTO, Model model) {
		ToyInfoDTO info = toyService.toysearch(toyDestDTO);
		model.addAttribute("info", info);
		return "toyresult";
		
	}
	

}
