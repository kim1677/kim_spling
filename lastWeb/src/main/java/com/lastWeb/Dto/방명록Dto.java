package com.lastWeb.Dto;

import com.lastWeb.Entity.방명록;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class 방명록Dto {
	private String userName;
	private String detail;
	
	public static 방명록Dto of(방명록 enty) {
		방명록Dto dto = new 방명록Dto();
		dto.setUserName(enty.getUserName());
		dto.setDetail(enty.getDetail());
		return dto;
	}
	
	// of 메서드 사용법 : static 메서드이기 때문에 반드시 클래스이름으로 호출해야한다.
	//				   방명록Dto.of()
	// of 메서드( ) 괄호 안에는 entity 객체를 넣어야한다.
	// 	방명록Dto dto객체 = 방명록Dto.of(entityr객체);
}
