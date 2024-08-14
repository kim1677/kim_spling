package com.movieAndgame.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movieAndgame.Dao.GameMemberDao;
import com.movieAndgame.Dto.GameMember;

@Service
public class GameMemberService {
	
	@Autowired
	private GameMemberDao gameMemberDao;
	
	public void signUpsave(GameMember gameMember) {
		gameMemberDao.insert(gameMember);
	}
}
