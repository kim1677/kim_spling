package com.bookProject.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import com.bookProject.DTO.BkDTO;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class BkDAO {
    private final JdbcTemplate jt;
    public void save(BkDTO bkDTO) {
        String sql = "insert into bookinfo3 (btitl, bsubt, bvolu, bwrit, btran, bkeyw, bpubl, bpage, bdate, bpric, bsort, bcode, bcont, burl) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        jt.update(sql, bkDTO.getBtitl(), bkDTO.getBsubt(), bkDTO.getBvolu(), bkDTO.getBwrit(), bkDTO.getBtran(), bkDTO.getBkeyw(), bkDTO.getBpubl(), bkDTO.getBpage(), bkDTO.getBdate(), bkDTO.getBpric(), bkDTO.getBsort(), bkDTO.getBcode(), bkDTO.getBcont(), bkDTO.getBurl());
    }
    
    private static class BkDTORowMapper implements RowMapper<BkDTO>{
    	@Override
    	public BkDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
            BkDTO book=new BkDTO();
            book.setBid(rs.getInt("bid"));
            book.setBtitl(rs.getString("btitl"));
            book.setBsubt(rs.getString("bsubt"));
            book.setBvolu(rs.getInt("bvolu"));
            book.setBwrit(rs.getString("bwrit"));
            book.setBtran(rs.getString("btran"));
            book.setBkeyw(rs.getString("bkeyw"));
            book.setBpubl(rs.getString("bpubl"));
            book.setBpage(rs.getInt("bpage"));
            book.setBdate(rs.getString("bdate"));
            book.setBpric(rs.getInt("bpric"));
            book.setBsort(rs.getString("bsort"));
            book.setBcode(rs.getString("bcode"));
            book.setBcont(rs.getString("bcont"));
            book.setBurl(rs.getString("burl"));
            return book;
    	}
    }
    
    public List<BkDTO> findAll(){
        String sql="select * from bookinfo3 order by bid desc";
        return jt.query(sql, new BkDTORowMapper());
    }
    
    public BkDTO findById(int bid) {
    	String sql="select * from bookinfo3 where bid=?";
    	return jt.queryForObject(sql, new BkDTORowMapper(),bid);
    }
    
    public void delete(int bid) {
    	String sql="delete from bookinfo3 where bid=?";
    	jt.update(sql, bid);
    }
    
    public void update(BkDTO bkDTO) {
    	String sql="update bookinfo3 set btitl=?, bsubt=?, bvolu=?, bwrit=?, btran=?, bkeyw=?, bpubl=?, bpage=?, bdate=?, bpric=?, bsort=?, bcode=?, bcont=?, burl=? where bid=?";
    	jt.update(sql, bkDTO.getBtitl(), bkDTO.getBsubt(), bkDTO.getBvolu(), bkDTO.getBwrit(), bkDTO.getBtran(), bkDTO.getBkeyw(), bkDTO.getBpubl(), bkDTO.getBpage(), bkDTO.getBdate(), bkDTO.getBpric(), bkDTO.getBsort(), bkDTO.getBcode(), bkDTO.getBcont(), bkDTO.getBurl(), bkDTO.getBid());
    }
    
    // 페이징 처리된 도서 목록 조회
    public List<BkDTO> findAllPaginated(int page, int pageSize) {
        int offset = page * pageSize;
        String sql = "select * from bookinfo3 order by bid desc limit ? offset ?";
        return jt.query(sql, new BkDTORowMapper(), pageSize, offset);
    }

    // 총 도서 수를 반환하는 메서드
    public int countAll() {
        String sql = "select count(*) from bookinfo3";
        return jt.queryForObject(sql, Integer.class);
    }
    
}
