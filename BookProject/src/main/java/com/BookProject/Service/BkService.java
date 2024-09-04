package com.BookProject.Service;

import org.springframework.stereotype.Service;

import com.BookProject.DAO.BkDAO;
import com.BookProject.DTO.BkDTO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BkService {

    private final BkDAO bkDAO;

    public void saveBook(BkDTO bkDTO) {
    	// DAO를 통해 데이터베이스에 저장
        bkDAO.save(bkDTO);
    }
}
