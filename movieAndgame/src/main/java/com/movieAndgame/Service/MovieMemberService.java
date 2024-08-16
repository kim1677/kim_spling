package com.movieAndgame.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movieAndgame.Dao.MovieMemberDao;
import com.movieAndgame.Dto.MovieMember;

@Service // 이것을 활성화해야 자바빈에 등록됨
public class MovieMemberService {
	
	@Autowired
	private MovieMemberDao movieMemberDao;
	
	// 로그인 처리
	public MovieMember login(MovieMember movieMember) {
		return movieMemberDao.login(movieMember);
	}

	// 회원가입 데이터베이스 저장
	public boolean signUpsave(MovieMember movieMember) {
		// 이메일 중복 체크하여 중복이면 가입 안함
		// 이메일 중복이면 true 반환, 아니면 false 반환
		// 이메일(아이디) 중복 체크하는 방법
		// 1. 데이터베이스 쿼리문으로 조회
		// 2. 데이터베이스에서 전체 이메일 받아서 자바로 비교
		// 현제 가입된 모든 이메일 주소 받기
		List<String> emailList = movieMemberDao.findAllEmail();
		if(emailList.contains(movieMember.getEmail() ) )
			return true;
		
		// 사용자가 입력한 회원가입 양식의 데이터를 데이터베이스에 저장
		movieMemberDao.insert(movieMember);
		return false;
	}
}
