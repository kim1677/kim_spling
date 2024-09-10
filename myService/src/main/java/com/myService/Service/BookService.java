package com.myService.Service;

import org.springframework.stereotype.Service;

import com.myService.DTO.BookDto;
import com.myService.DTO.BookSearchDto;

@Service
public class BookService {
	
	public BookDto search(BookSearchDto bookSearchDto) {
		
		// 데이터베이스 조회했다 가정하
		// entitiy → Dto	
		BookDto bookDto = BookDto.of(bookSearchDto.getTitle() );
		return bookDto;
	}
    
}
