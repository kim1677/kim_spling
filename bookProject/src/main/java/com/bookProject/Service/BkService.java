package com.bookProject.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookProject.DAO.BkDAO;
import com.bookProject.DTO.BkDTO;

@Service
public class BkService {
	@Autowired
	private BkDAO bkDAO;
	public void bookSave(BkDTO bkDTO) { 
		if(bkDTO!=null) { 
			bkDAO.save(bkDTO); 
		} 
	}
	
	public List<BkDTO> findAllBooks(){ 
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
	
	 // 페이징 처리된 책 목록을 가져오는 메서드
    public List<BkDTO> findPaginated(int page, int pageSize) {
        return bkDAO.findAllPaginated(page, pageSize);
    }

    // 전체 도서 수를 반환하는 메서드
    public int countAllBooks() {
        return bkDAO.countAll();
    }
    
}
