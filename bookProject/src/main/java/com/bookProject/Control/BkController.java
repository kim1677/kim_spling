package com.bookProject.Control;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.bookProject.DTO.BkDTO;
import com.bookProject.Service.BkService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class BkController {
	private final BkService bkService;
	
	@GetMapping("/")
	public String home(Model model, @RequestParam(defaultValue = "0") int page) {
	    int pageSize = 10;
	    int totalBooks = bkService.countAllBooks();
	    int totalPages = (int) Math.ceil((double) totalBooks / pageSize);

	    List<BkDTO> bookList = bkService.findPaginated(page, pageSize);
	    model.addAttribute("bookList", bookList);
	    model.addAttribute("currentPage", page);
	    model.addAttribute("totalPages", totalPages);

	    return "book/index";
	}
	
	@GetMapping("/search")
	public String search(){
		return "book/search";
	}
	
	@GetMapping("/write")
	public String write(Model model){
		model.addAttribute("bkDTO",new BkDTO());
		return "book/write";
	}
	
	@PostMapping("/write")
	public String write(@ModelAttribute BkDTO bkDTO) {
		MultipartFile bimg=bkDTO.getBimg();
		if(!bimg.isEmpty()) {
			try {
				String fileName=bimg.getOriginalFilename();
				String savePath="C:/img/"+fileName;
				bimg.transferTo(new File(savePath));
				bkDTO.setBurl("/image/"+fileName);
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		bkService.bookSave(bkDTO);
		return "redirect:/write";
	}
	
	@GetMapping("/view/{bid}")
	public String view(@PathVariable("bid") int bid, Model model){
		model.addAttribute("bkDTO",bkService.findById(bid));
		return "book/view";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("bid") int bid) {
		bkService.delete(bid);
		return "redirect:/";
	}
	
	@PostMapping("/update")
	public String update(@ModelAttribute BkDTO bkDTO) {
		MultipartFile bimg=bkDTO.getBimg();
		if(!bimg.isEmpty()) {
			try {
				String fileName=bimg.getOriginalFilename();
				String savePath="C:/img/"+fileName;
				bimg.transferTo(new File(savePath));
				bkDTO.setBurl("/image/"+fileName);
			}catch(IOException e) {
				e.printStackTrace();
			}
		}else {
			bkDTO.setBurl(bkService.findById(bkDTO.getBid()).getBurl());
		}
		bkService.update(bkDTO);
		return "redirect:/view/"+bkDTO.getBid();
	}
	
}
