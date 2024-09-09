package com.BookProject.Service;

import java.util.List;

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
    
    public List<BkDTO> findAllBooks(){
		return bkDAO.findAll();
	}
    
	public BkDTO findById(int id) {
		return bkDAO.findById(id);
	}

	public void delete(int bid) {
		bkDAO.delete(bid);
	}

	public void update(BkDTO bkDTO) {
		bkDAO.update(bkDTO);
	}
    
    
}
