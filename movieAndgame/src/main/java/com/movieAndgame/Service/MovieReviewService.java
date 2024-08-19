package com.movieAndgame.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movieAndgame.Dao.MovieReviewDaoImpl;
import com.movieAndgame.Dto.MovieReviewDto;

@Service
public class MovieReviewService {
	
	@Autowired
	private MovieReviewDaoImpl movieReviewDao;
	
	// movie_review 테이블에서 데이터 가져와서 컨틀럴에 전달(목록 전달)
	public List<MovieReviewDto> reviewlist(){
		return movieReviewDao.findAll();
	}
	
	public void save(MovieReviewDto movieReviewDto) {
		movieReviewDao.reviewSave(movieReviewDto);
	}

	public MovieReviewDto findById(int id) {
		return movieReviewDao.findById(id);
		
	}
}
