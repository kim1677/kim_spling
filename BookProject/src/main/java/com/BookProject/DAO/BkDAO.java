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

    public void save(BkDTO bkDTO) {
        String sql = "INSERT INTO bookinfo2 (bid, btitl, burl) VALUES (?, ?, ?)";
        jt.update(sql, bkDTO.getBid(), bkDTO.getBtitl(), bkDTO.getBurl());
    }
    
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
    
    public List<BkDTO> findAll(){
        String sql = "SELECT * FROM bookinfo2";
        List<BkDTO> list=jt.query(sql, new BkDTORowMapper());
        return list;
        
    }
    public BkDTO findById(int id) {
    	String sql="select * from bookinfo2 where bid=?";
    	BkDTO bkDTO=jt.queryForObject(sql, new BkDTORowMapper(),id);
    	return bkDTO;
    }

  
}

