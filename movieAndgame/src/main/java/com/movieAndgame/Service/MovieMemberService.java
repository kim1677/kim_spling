package com.movieAndgame.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movieAndgame.Dao.MovieMemberDao;
import com.movieAndgame.Dto.MovieMember;

@Service // 이것을 활성화해야 자바빈에 등록됨
public class MovieMemberService {
	
	@Autowired
	private MovieMemberDao movieMemberDao;

	// 회원가입 데이터베이스 저장
	public void signUpsave(MovieMember movieMember) {
		movieMemberDao.insert(movieMember);
	}
}
