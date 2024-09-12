package com.bookProject.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BkSearchDTO {
	private String btitl;
	private String bwrit;
	private String bpubl;
	private String bsort;
	
	private String searchType;   	// 검색 기준을 저장하는 새 필드 (책 제목, 지은이, 출판사, 분류)
    private String searchKeyword;  // 실제 검색어를 위한 새 필드

}
