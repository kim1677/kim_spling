package com.example.bookTest.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Controller;

import ch.qos.logback.core.db.DriverManagerConnectionSource;

@Controller
public class AppConfig {
	
	@Bean	// jdbc bean 등록
	public DataSource dataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUsername("Kimkj");
		ds.setPassword("123456");
		ds.setUrl("jdbc:mysql://localhost:3306/Kimkj");
		return ds;
	}
	
	@Bean	// jdbc 실행
	public JdbcTemplate jdbcTemplate(DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}
}
