package com.example.bookTest.CoffeService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bookTest.Dao.CoffeDao;
import com.example.bookTest.Dto.CoffeDto;

@Service
public class CoffeService {
	private final CoffeDao coffeDao;
	
	@Autowired
	public CoffeService(CoffeDao coffeDao) {
		this.coffeDao=coffeDao;
	}
	
	public List<CoffeDto> selectAll(){
		return coffeDao.select();
	}
	
	public void coffeSave(CoffeDto coffeDto) {
		if(coffeDto !=null) {
			coffeDao.save(coffeDto);	// DAO 클래스의 save 메서드 실행해서 저장
		}
	}	
}
