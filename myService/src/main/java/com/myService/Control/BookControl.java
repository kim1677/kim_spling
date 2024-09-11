package com.myService.Control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.myService.DTO.BookDto;
import com.myService.DTO.BookSearchDto;
import com.myService.Service.BookService;

import lombok.RequiredArgsConstructor;


@Controller
@RequiredArgsConstructor
public class BookControl {
	
	private final BookService bookService;

	@GetMapping("/book")
		public String main() {
			return "book";
	}
	
	// 책 제목 입력 페이지 요청
	@GetMapping("/booksearch")
	public String search(Model model) {
		model.addAttribute("bookSearch", new BookSearchDto() );
		return "search";
	}
	
	// 입력한 책 제목 검색요청
	@GetMapping("/searchkeyword")
	public String bookSearch(BookSearchDto bookSearchDto, Model model) {
		
		BookDto bookDto = bookService.search(bookSearchDto);
		model.addAttribute("bookDto", bookDto);
		
		return "result";
	}
		
}
