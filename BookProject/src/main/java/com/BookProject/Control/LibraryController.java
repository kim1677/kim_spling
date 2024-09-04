package com.BookProject.Control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
    public String book() {
        return "book/bookindex";
    }

    @GetMapping("/search")
    public String search() {
        return "book/search";
    }

    @GetMapping("/write")
    public String write(Model model) {
    	BkDTO bkDTO = new BkDTO();
    	model.addAttribute("BkDTO", bkDTO);
        return "book/write";
    }

    @PostMapping("/bookindex")
    public String bookwrite(BkDTO bkDTO, Model model) {
        // Service를 사용하여 DTO를 DAO로 넘깁
        bkService.saveBook(bkDTO);
        return "book/bookindex";
    }

    @GetMapping("view")
    public String view() {
        return "book/view";
    }
}
