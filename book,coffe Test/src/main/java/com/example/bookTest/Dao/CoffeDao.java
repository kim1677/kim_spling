package com.example.bookTest.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.bookTest.Dto.BookDto;
import com.example.bookTest.Dto.CoffeDto;

@Repository
public class CoffeDao {
	private final JdbcTemplate db;
	
	@Autowired
	public CoffeDao(JdbcTemplate jdbc) {
		this.db = jdbc;
	}
	
	public void update(CoffeDto coffeDto) {
		String sql="update coffe set item_Name=?, price=?, decaffein=? where coffe_id=?";
		db.update(sql, coffeDto.getItemName(), coffeDto.getPrice(), coffeDto.getDecaffein(), coffeDto.getCoffeId() );
	}
	
	public void delete(int bid) {
		String sql="delete from coffe where coffe_id=?";
		db.update(sql, bid);
	}
	
	public CoffeDto findId(int cid) {
		String sql="select * from coffe where coffe_id=?";
		CoffeDto dto = db.queryForObject(sql, 
			new RowMapper<CoffeDto>() {
			@Override
			public CoffeDto mapRow(ResultSet rs, int rowNum) throws SQLException{
				CoffeDto coffeDto = new CoffeDto();
				coffeDto.setItemName(rs.getString("item_name"));
				coffeDto.setPrice(rs.getInt("price"));
				coffeDto.setDecaffein(rs.getInt("decaffein"));
				coffeDto.setCoffeId(rs.getInt("coffe_id"));
				return coffeDto;
			}
		} ,cid);
		
		return dto;
	}
	
	public List<CoffeDto> select(){
		String sql="select * from coffe";
		List<CoffeDto> list = db.query(sql, new CoffeDtoRowMapper() );
		return list;
	}
	
	public void save(CoffeDto coffeDto) {
		String  sql="insert into coffe(item_name, price, decaffein) values(?,?,?)";
		db.update(sql, coffeDto.getItemName(), coffeDto.getPrice(), coffeDto.getDecaffein() );
	}
	
	public class CoffeDtoRowMapper implements RowMapper<CoffeDto>{
		@Override
		public CoffeDto mapRow(ResultSet rs, int rowNum) throws SQLException {
			CoffeDto coffeDto = new CoffeDto();
			coffeDto.setItemName(rs.getString("item_name"));
			coffeDto.setPrice(rs.getInt("price"));
			coffeDto.setDecaffein(rs.getInt("decaffein"));
			coffeDto.setCoffeId(rs.getInt("coffe_id"));
			return coffeDto;
		}
	}
	
}
