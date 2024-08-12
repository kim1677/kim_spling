package com.example.bookTest.CoffeService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bookTest.Dao.CoffeDao;
import com.example.bookTest.Dto.BookDto;
import com.example.bookTest.Dto.CoffeDto;

@Service
public class CoffeService {
	private final CoffeDao coffeDao;
	
	@Autowired
	public CoffeService(CoffeDao coffeDao) {
		this.coffeDao=coffeDao;
	}
	
	public void update(CoffeDto coffeDto) {
		coffeDao.update(coffeDto);
	}	
	
	public void remove(int bid) {
		coffeDao.delete(bid);
	}
	
	public CoffeDto getCoffe(int id) {
		if(id !=0) {	// id 파라미터의 값이 존재한다면 DAO를 통해 조회
			return coffeDao.findId(id);
		}
		return null;	//  id 파라미터 없이 /book/view 주소 요청 들어 온다면 null값 반환
	}
	
//	public CoffeDto getMenu(int id) {
//		return coffeDao.findById(id);
//	}
	
	public List<CoffeDto> selectAll(){
		return coffeDao.select();
	}
	
	public void coffeSave(CoffeDto coffeDto) {
		if(coffeDto !=null) {
			coffeDao.save(coffeDto);	// DAO 클래스의 save 메서드 실행해서 저장
		}
	}	
}
