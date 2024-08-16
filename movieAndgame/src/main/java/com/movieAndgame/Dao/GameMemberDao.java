package com.movieAndgame.Dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.movieAndgame.Dto.GameMember;

@Mapper
public interface GameMemberDao {
	public void insert(GameMember gameMember);
	public List<String> findAllEmail();
	public GameMember login(GameMember gameMember);
	
}
