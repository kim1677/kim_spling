package com.myService.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.myService.DTO.PitcherDto;
import com.myService.Data.Ranking;

@Service
public class BaseBallService {
	
	public List<PitcherDto> searchPitcher(PitcherDto pitcherDto) {
		
		// 투수이름으로 데이터베이스에서 조회아여 가져왔다는 가정하
		// 데이터베이스어세 가져온 데이터들을 DTO에 저장해야 한다.
		
		// DTO 객체 생성하여 데이터들 저장 시키는 방법
		// 1. 클래스 메서드를 구현하여 객체 생성
		// 2. DTO 생성자 메서드로 생성
		// 3. DAO 또는 Entity의 내부 클래스로 생성하여 사용하는 방법
		
		List<Ranking.Pitcher> list = Ranking.plist();
		
		List<PitcherDto> pitcherDtoList = new ArrayList<>();
		
		for(Ranking.Pitcher pitcher : list) {
			pitcherDtoList.add(pitcherDto.of(pitcher.getName(), pitcher.getLostPoint(), pitcher.getStrikeOut(), pitcher.getEra() ) );
		
		}
		
		return pitcherDtoList;
	}

}
