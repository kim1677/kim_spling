package com.movieAndgame.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movieAndgame.Dao.GameReviewDaoImpl;
import com.movieAndgame.Dto.GameReviewDto;

@Service
public class GameReviewService {
	
	@Autowired
	private GameReviewDaoImpl gameReviewDao;
	
	public List<GameReviewDto> reviewlist() {
		return gameReviewDao.findAll();
	}
	
	public void save(GameReviewDto gameReviewDto) {
		gameReviewDao.reviewSave(gameReviewDto);
	}

	public GameReviewDto findById(int id) {
		return gameReviewDao.findById(id);
	}
	
}
