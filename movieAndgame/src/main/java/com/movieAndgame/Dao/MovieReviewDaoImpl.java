package com.movieAndgame.Dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.movieAndgame.Dto.MovieReviewDto;

@Mapper
public interface MovieReviewDaoImpl {
	public int reviewSave(MovieReviewDto movieReviewDto);
	
	// 전체 데이터 가져오기 - 목록 출력
	public List<MovieReviewDto> findAll();

	// 글 상세 보기 - 데이터베이스에서 가져오기 review_id로 조회
	public MovieReviewDto findById(int id);
}
