package com.lastWeb.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.lastWeb.Dto.방명록Dto;
import com.lastWeb.Entity.방명록;
import com.lastWeb.디비.Repo방명록;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class Service방명록 {
	
	private final Repo방명록 repo방명록;
	
	// Dto에 저장되어 있는 데이터를 entity로 바꿔주고 데이터베이스에 저장까지 하는 내용을 가진 메서드 만들기
	public void 방명록저장(방명록Dto dto) {
		// 1. Dto → entity
		방명록 entity = new 방명록();
		entity.setUserName(dto.getUserName() );
		entity.setDetail(dto.getDetail() );
		
		// 2. entity를 repository를 통해 save
		repo방명록.save(entity);
		
	}
	
	public List<방명록Dto> getDatas(){
		
		// 뷰페이지에 데이터를 출력하기 위해 Dto에 담아준다. , 여러개이기 때문에 List 
		List<방명록Dto> dtos = new ArrayList<>();
		
		// 데이터베이스에서 조회해서 가져오려면 findXXX.. 메서드를 사용한다.
		// 핸당 entity 테이블의 전부 가져오려면 findAll 하면 된다.
		// findAll은 jpa에 만들어져있는 메서드 이름이다.
		
		List<방명록> list = repo방명록.findAll();
		
		// entity → Dto
		for(방명록 data : list) {
			// data는 entity 객체이다.
			dtos.add(방명록Dto.of(data));
			
		}
		
		return dtos;
		
	}
}
