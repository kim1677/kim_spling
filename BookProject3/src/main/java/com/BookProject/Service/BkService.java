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
		if (bkDTO!=null) { 
			bkDAO.save(bkDTO); 
		} 
	}
	
	public List<BkDTO> findAllBooks() {
		return bkDAO.findAll(); 
	}
	
	public BkDTO findById(int bid) { 
		return bkDAO.findById(bid); 
	}
	
	public void delete(int bid) { 
		bkDAO.delete(bid); 
	}
	
	public void update(BkDTO bkDTO) { 
		bkDAO.update(bkDTO); 
	}
	
}
