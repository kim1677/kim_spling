package com.example.bookTest.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.bookTest.Dto.CoffeDto;

@Repository
public class CoffeDao {
	private final JdbcTemplate jt;
	
	@Autowired
	public CoffeDao(JdbcTemplate jdbc) {
		this.jt = jdbc;
	}
	
	public List<CoffeDto> select(){
		String sql="select * from coffe";
		List<CoffeDto> list = jt.query(sql, new CoffeDtoRowMapper() );
		return list;
	}
	
	
	public void save(CoffeDto coffeDto) {	// 커피정보 데이터베이스에 저장
		String  sql="insert into coffe(item_name, price, decaffein) values(?,?,?)";
		jt.update(sql, coffeDto.getItemName(), coffeDto.getPrice(), coffeDto.getDecaffein() );
	}
	
	public class CoffeDtoRowMapper implements RowMapper<CoffeDto>{
		@Override
		public CoffeDto mapRow(ResultSet rs, int rowNum) throws SQLException {
			CoffeDto coffeDto = new CoffeDto();
			coffeDto.setItemName(rs.getString("item_name"));
			coffeDto.setPrice(rs.getInt("price"));
			coffeDto.setDecaffein(rs.getInt("decaffein"));
			coffeDto.setCoffeId(rs.getInt("coffe_Id"));
			return coffeDto;
		}
	}
	
}
