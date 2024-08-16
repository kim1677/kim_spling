package com.movieAndgame.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movieAndgame.Dao.GameMemberDao;
import com.movieAndgame.Dto.GameMember;

@Service
public class GameMemberService {
	
	@Autowired
	private GameMemberDao gameMemberDao;
	
	public GameMember login(GameMember gameMember) {
		return gameMemberDao.login(gameMember);
	}
	
	public boolean signUpsave(GameMember gameMember) {
		List<String> emailList = gameMemberDao.findAllEmail();
		if(emailList.contains(gameMember.getEmail() ) )
			return true;
		
		gameMemberDao.insert(gameMember);
		return false;
	}
}
