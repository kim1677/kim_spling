package com.movieAndgame.Dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.movieAndgame.Dto.MovieMember;

@Mapper
public interface MovieMemberDao {
	// 메서드 작성
	public int insert(MovieMember movieMember);			// 회원가입 데이터 저장
	public List<String> findAllEmail();					// 이메일 중복 체크확인
	public MovieMember login(MovieMember movieMember);	// 로그인 처리
	
}
