package com.BookProject.DAO;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.BookProject.DTO.BkDTO;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class BkDAO {

    private final JdbcTemplate jdbcTemplate;

    public void save(BkDTO bkDTO) {
        String sql = "INSERT INTO bookinfo2 (bid, btitl, bimg) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, bkDTO.getBid(), bkDTO.getBtitl(), bkDTO.getBimg());
    }
}

