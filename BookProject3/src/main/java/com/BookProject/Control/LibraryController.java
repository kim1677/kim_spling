package com.BookProject.Control;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.BookProject.DTO.BkDTO;
import com.BookProject.Service.BkService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class LibraryController {

    private final BkService bkService;
    
    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/bookindex")
    public String book(Model model) {
        // 등록된 도서 목록을 조회하여 모델에 추가
        List<BkDTO> bookList = bkService.findAllBooks();
        model.addAttribute("bookList", bookList);
        return "book/bookindex";
    }

    @GetMapping("/search")
    public String search() {
        return "book/search";
    }

    @GetMapping("/write")
    public String write(Model model) {
    	BkDTO bkDTO = new BkDTO();
    	model.addAttribute("bkDTO", bkDTO);
        return "book/write";
    }

    @PostMapping("/bookindex")
    public String bookwrite(BkDTO bkDTO, Model model) {
        // Service를 사용하여 DTO를 DAO로 넘깁
        bkService.saveBook(bkDTO);
        return "redirect:/bookindex";
    }

    @PostMapping("/write")
    public String write(@ModelAttribute BkDTO bkDTO) {
        MultipartFile bimg=bkDTO.getBimg();
        if (!bimg.isEmpty()) {
            try {
                String fileName=bimg.getOriginalFilename();
                String savePath="C:/img/" + fileName;
                bimg.transferTo(new File(savePath));
                bkDTO.setBurl("/image/" + fileName);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        bkService.saveBook(bkDTO);
        return "redirect:/bookindex";
    }

    @GetMapping("/view/{id}")
	public String view(@PathVariable("id") int id, Model model){
		BkDTO bkDTO=bkService.findById(id);
		model.addAttribute("bkDTO",bkDTO);
		return "book/view";
	}
    
    @GetMapping("/delete")
    public String delete(@RequestParam("bid") int bid) {
        bkService.delete(bid);
        return "redirect:/bookindex";
    }
    
    @PostMapping("/update")
	public String update(@ModelAttribute BkDTO bkDTO) {
		MultipartFile bimg=bkDTO.getBimg();
		if(!bimg.isEmpty()) {
			try {
				String fileName=bimg.getOriginalFilename();
				String savePath="C:/img/"+fileName;
				bimg.transferTo(new File(savePath));
				bkDTO.setBurl("/img/"+fileName);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else {
			bkDTO.setBurl(bkService.findById(bkDTO.getBid()).getBurl());
		}
		
		bkService.update(bkDTO);
		return "redirect:/bookindex";
//		return "redirect:/view/" +bkDTO.getBid();
	}
 
}
