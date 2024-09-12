package com.bookProject.Control;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bookProject.DTO.BkDTO;
import com.bookProject.DTO.BkSearchDTO;
import com.bookProject.Service.BkService;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class BkController {
	
	private final BkService bkService;
	
	@GetMapping("/")
	public String home(Model model, @RequestParam(defaultValue = "0") int page) {
		int pageSize = 10;
        List<BkDTO> bookList = bkService.findPaginated(page, pageSize);
        int totalBooks = bkService.countAllBooks();
        int totalPages = (int) Math.ceil((double) totalBooks / pageSize);
        model.addAttribute("bookList", bookList);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", totalPages);
        return "book/index";
    }
	
	@GetMapping("/search")
	public String search(Model model){
		model.addAttribute("bkSearchDTO", new BkSearchDTO());
		return "book/search";
	}
	
	@GetMapping("/searchkeyword")
	public String bookSearch(HttpServletRequest rq, Model model, RedirectAttributes ra) {
		String st1=rq.getParameter("searchType1");
		String sk1=rq.getParameter("searchKeyword1");
		String st2=rq.getParameter("searchType2");
		String sk2=rq.getParameter("searchKeyword2");
		String st3=rq.getParameter("searchType3");
		String sk3=rq.getParameter("searchKeyword3");
		String st4=rq.getParameter("searchType4");
		String sk4=rq.getParameter("searchKeyword4");
		List<BkDTO> books=bkService.searchBooksByMultipleCriteria(st1, sk1, st2, sk2, st3, sk3, st4, sk4);
		if(books.isEmpty()) {
			ra.addFlashAttribute("alertMessage","검색 결과가 없습니다");
			return "redirect:/search";
		}
		model.addAttribute("books",books);
		model.addAttribute("st1",st1);
		model.addAttribute("sk1",sk1);
		model.addAttribute("st2",st2);
		model.addAttribute("sk2",sk2);
		model.addAttribute("st3",st3);
		model.addAttribute("sk3",sk3);
		model.addAttribute("st4",st4);
		model.addAttribute("sk4",sk4);
		return "book/results";
	}

	@GetMapping("/write")
	public String write(Model model){
		model.addAttribute("bkDTO",new BkDTO());
		return "book/write";
	}
	
	@PostMapping("/write")
	public String write(@ModelAttribute BkDTO bkDTO, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) { return "book/write"; }
		MultipartFile bimg=bkDTO.getBimg();
		if(!bimg.isEmpty()) {
			try {
				UUID uuid=UUID.randomUUID();
				String originalName=bimg.getOriginalFilename();
				String ext=originalName.substring(originalName.lastIndexOf("."));
				String saveName=uuid.toString()+ext;
				String savePath="C:/lalalandddd/bookimage/"+saveName;
				bimg.transferTo(new File(savePath));
				bkDTO.setBurl("/image/"+saveName);
				bkDTO.setFilename(saveName);
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		bkService.bookSave(bkDTO);
		return "redirect:/write";
	}
	
	@GetMapping("/view/{bid}")
	public String view(@PathVariable("bid") Long bid, Model model){
		model.addAttribute("bk",bkService.findById(bid));
		return "book/view";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("bid") Long bid) {
		bkService.delete(bid);
		return "redirect:/";
	}
	@PostMapping("/update")
	public String update(@ModelAttribute BkDTO bkDTO, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) { return "book/write"; }
		MultipartFile bimg=bkDTO.getBimg();
		if(!bimg.isEmpty()) {
			try {
				UUID uuid=UUID.randomUUID();
				String originalName=bimg.getOriginalFilename();
				String ext=originalName.substring(originalName.lastIndexOf("."));
				String saveName=uuid.toString()+ext;
				String savePath="C:/lalalandddd/bookimage/"+saveName;
				bimg.transferTo(new File(savePath));
				bkDTO.setBurl("/image/"+saveName);
				bkDTO.setFilename(saveName);
			}catch(IOException e) {
				e.printStackTrace();
			}
		} else {
            bkDTO.setBurl(bkService.findById(bkDTO.getBid()).getBurl());
        }
		
		bkService.update(bkDTO);
		return "redirect:/view/"+bkDTO.getBid();
	}
	
}
