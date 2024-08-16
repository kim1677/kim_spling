package com.movieAndgame.Dao;

import org.apache.ibatis.annotations.Mapper;

import com.movieAndgame.Dto.MovieReviewDto;

@Mapper
public interface MovieReviewDaoImpl {
	public int reviewSave(MovieReviewDto movieReviewDto);
}
