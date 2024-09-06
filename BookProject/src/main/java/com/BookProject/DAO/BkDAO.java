package com.BookProject.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.BookProject.DTO.BkDTO;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class BkDAO {

    private final JdbcTemplate jt;
    
    // 도서 정보를 데이터베이스에 저장하는 메서드
    public void save(BkDTO bkDTO) {
    	// SQL 쿼리: bookinfo2 테이블에 새로운 도서 정보를 삽입
    	String sql = "INSERT INTO bookinfo2 (bid, btitl, burl) VALUES (?, ?, ?)";
        jt.update(sql, bkDTO.getBid(), bkDTO.getBtitl(), bkDTO.getBurl());
    }
    
    // ResultSet을 BkDTO 객체로 변환하는 RowMapper 구현 클래스
    public class BkDTORowMapper implements RowMapper<BkDTO>{
    	@Override
    	public BkDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
            BkDTO book = new BkDTO();
            book.setBid(rs.getInt("bid"));
            book.setBtitl(rs.getString("btitl"));
//            book.setBsubt(rs.getString("bsubt"));
//            book.setBvolu(rs.getInt("bvolu"));
//            book.setBwrit(rs.getString("bwrit"));
//            book.setBtran(rs.getString("btran"));
//            book.setBkeyw(rs.getString("bkeyw"));
//            book.setBpubl(rs.getString("bpubl"));
//            book.setBpage(rs.getInt("bpage"));
//            book.setBdate(rs.getString("bdate"));
//            book.setBpric(rs.getInt("bpric"));
//            book.setBsort(rs.getString("bsort"));
//            book.setBcode(rs.getString("bcode"));
//            book.setBcont(rs.getString("bcont"));
            book.setBurl(rs.getString("burl"));
            return book;
    	}
    }
    
    // 데이터베이스에서 모든 도서 정보를 조회하는 메서드
    public List<BkDTO> findAll(){
    	// SQL 쿼리: bookinfo2 테이블의 모든 데이터를 선택
        String sql = "SELECT * FROM bookinfo2";
        // SQL 쿼리: bookinfo2 테이블의 모든 데이터를 선택
        List<BkDTO> list=jt.query(sql, new BkDTORowMapper());
        return list;
        
    }
    
    // 주어진 ID로 도서 정보를 조회하는 메서드
    public BkDTO findById(int id) {
    	String sql="select * from bookinfo2 where bid=?";
    	// JdbcTemplate을 사용하여 쿼리를 실행하고 결과를 BkDTORowMapper로 매핑하여 단일 객체 반환
    	BkDTO bkDTO=jt.queryForObject(sql, new BkDTORowMapper(),id);
    	return bkDTO;
    }

  
}

