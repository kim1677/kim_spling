package com.movieAndgame.Dao;

import org.apache.ibatis.annotations.Mapper;

import com.movieAndgame.Dto.MovieMember;

@Mapper
public interface MovieMemberDao {
	public int insert(MovieMember movieMember);	// 회원가입 데이터 저장
}
