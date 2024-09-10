package com.myService.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookDto {
	private String title;
    private String writer;
    private int year;
    private int page;
    
    // entity → Dto
    public static BookDto of(String title) {	// of(entitiy 객체를 매개변수로 받는다.)
    	// Dto 객체 생성
    	BookDto bookDto = new BookDto();
    	bookDto.setTitle(title);
    	bookDto.setPage(234);
    	bookDto.setWriter("박문수");
    	bookDto.setYear(2019);
    	return bookDto;
    	
    }
}
