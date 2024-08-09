package com.example.bookTest.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.bookTest.Dto.BookDto;

@Repository
public class BookDAO {
	private final JdbcTemplate jt;
	
	@Autowired
	public BookDAO(JdbcTemplate jdbcTemplate) {
		this.jt = jdbcTemplate;
	}
	
	// 수정 도서의 정보를 데이터 베이스에 수정하여 저장하기
	public void update(BookDto bookDto) {
		String sql="update book set book_title=?, book_author=?, book_cost=?, book_page=?, publisher=?, where book_id=?"; 
		jt.update(sql, bookDto.getBookTitle(), bookDto.getBookAuthor(), bookDto.getBookCost(), bookDto.getBookPage(), bookDto.getPublisher(), bookDto.getBookId() );
	}
	
	// 도서삭제
	public void delete(int bid) {
		String sql="delete from book where book_id=?";
		jt.update(sql, bid);
	}
	
	// 도서 상세 정보 가져오기 - 1권에 대해서만!!(book_id 컬럼으로 조회)
	// book_id 컬럼이 중복데이터를 가질 수 없는 유일값이기 때문
	public BookDto findId(int id) {
		String sql="select * from book where book_id=?";
		BookDto data = jt.queryForObject(sql, 
			new RowMapper<BookDto>() {
			@Override
			public BookDto mapRow(ResultSet rs, int rowNum) throws SQLException{
				BookDto bookDto = new BookDto();
				bookDto.setBookAuthor(rs.getString("book_author"));
				bookDto.setBookCost(rs.getInt("book_cost"));
				bookDto.setBookPage(rs.getInt("book_page"));
				bookDto.setBookTitle(rs.getString("book_title"));
				bookDto.setPublisher(rs.getString("publisher"));
				bookDto.setBookId(rs.getInt("book_id"));
				return bookDto;
			}
		} ,id);
		
		return data;
	}
	
	
	// book 데이블 전체 데이터 가져오기 - 첫화면에 목록으로 출력하기 위함
	public List<BookDto> select(){
		String sql="select * from book";
		List<BookDto> list = jt.query(sql, new BookDtoRowMapper() );
		return list;
	}
	
	// 도서정보 데이터베이스에 저장
	public void insert(BookDto bookDto) {
		String  sql="insert into book(book_title, book_author, book_cost, book_page, publisher) values(?,?,?,?,?)";
		jt.update(sql, bookDto.getBookTitle(), bookDto.getBookAuthor(), bookDto.getBookCost(), bookDto.getBookPage(), bookDto.getPublisher() );
	}
	
	// SQL쿼리 결과 BookDto 객체로 변환
	public class BookDtoRowMapper implements RowMapper<BookDto>{
		// 컬럼을 가져와서 BookDto 객체의 필드에 매핑
		@Override
		public BookDto mapRow(ResultSet rs, int rowNum) throws SQLException {
			BookDto bookDto = new BookDto();
			bookDto.setBookAuthor(rs.getString("book_author"));
			bookDto.setBookCost(rs.getInt("book_cost"));
			bookDto.setBookPage(rs.getInt("book_page"));
			bookDto.setBookTitle(rs.getString("book_title"));
			bookDto.setPublisher(rs.getString("publisher"));
			bookDto.setBookId(rs.getInt("book_id"));
			return bookDto;
		}
	}

	
}
