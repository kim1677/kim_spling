package com.bookProject.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.bookProject.DTO.BkDTO;
import com.bookProject.DTO.BkSearchDTO;
import com.bookProject.Entity.Bk;
import com.bookProject.Repository.BkRepository;


@Service
public class BkService {
	@Autowired
	private BkRepository bkRepository;
	public void bookSave(BkDTO bkDTO) {
		Bk bk=convertDTOToEntity(bkDTO);
		if(bk!=null) {
			bkRepository.save(bk);
		}
	}
	
	public List<Bk> findAllBooks(){ 
		return bkRepository.findAll(); 
	}
	
	public BkDTO findById(Long bid) {
		Optional<Bk> optionalBk=bkRepository.findById(bid);
		if(optionalBk.isPresent()) {
			return convertEntityToDTO(optionalBk.get());
		}
		return null;
	}
	
	@Transactional
	public void delete(Long bid) { bkRepository.deleteById(bid); }
	public void update(BkDTO bkDTO) {
		Bk bk=convertDTOToEntity(bkDTO);
		if(bkRepository.existsById(bk.getBid())) {
			bkRepository.save(bk);
		}
	}
	
	public List<BkDTO> findPaginated(int page, int pageSize) {
		Pageable pageable=PageRequest.of(page, pageSize, Sort.by("bid").descending());
		Page<Bk> paginatedResult=bkRepository.findAll(pageable);
		List<BkDTO> booklist=paginatedResult
				.stream()
				.map(this::convertEntityToDTO)
				.collect(Collectors.toList());
		return booklist;
	}
	
	public int countAllBooks() {
			return (int) bkRepository.count();
	}
	
	private Bk convertDTOToEntity(BkDTO bkDTO) {
		Bk bk=new Bk();
		bk.setBid(bkDTO.getBid());
		bk.setBtitl(bkDTO.getBtitl());
		bk.setBsubt(bkDTO.getBsubt());
		bk.setBvolu(bkDTO.getBvolu());
		bk.setBwrit(bkDTO.getBwrit());
		bk.setBtran(bkDTO.getBtran());
		bk.setBkeyw(bkDTO.getBkeyw());
		bk.setBpubl(bkDTO.getBpubl());
		bk.setBpage(bkDTO.getBpage());
		bk.setBdate(bkDTO.getBdate());
		bk.setBpric(bkDTO.getBpric());
		bk.setBsort(bkDTO.getBsort());
		bk.setBcode(bkDTO.getBcode());
		bk.setBcont(bkDTO.getBcont());
		bk.setBurl(bkDTO.getBurl());
		bk.setFilename(bkDTO.getFilename());
		return bk;
	}
	
	private BkDTO convertEntityToDTO(Bk bk) {
		BkDTO bkDTO=new BkDTO();
		bkDTO.setBid(bk.getBid());
		bkDTO.setBtitl(bk.getBtitl());
		bkDTO.setBsubt(bk.getBsubt());
		bkDTO.setBvolu(bk.getBvolu());
		bkDTO.setBwrit(bk.getBwrit());
		bkDTO.setBtran(bk.getBtran());
		bkDTO.setBkeyw(bk.getBkeyw());
		bkDTO.setBpubl(bk.getBpubl());
		bkDTO.setBpage(bk.getBpage());
		bkDTO.setBdate(bk.getBdate());
		bkDTO.setBpric(bk.getBpric());
		bkDTO.setBsort(bk.getBsort());
		bkDTO.setBcode(bk.getBcode());
		bkDTO.setBcont(bk.getBcont());
		bkDTO.setBurl(bk.getBurl());
		bkDTO.setFilename(bk.getFilename());
		return bkDTO;
	}
	
	public BkDTO search(BkSearchDTO bkSearchDTO) {
		BkDTO bkDTO = BkDTO.of(bkSearchDTO.getBtitl());
		return bkDTO;
	}

	public Page<BkDTO> searchBooksByMultipleCriteria(String st1, String sk1, String st2, String sk2, String st3, String sk3, String st4, String sk4, Pageable pageable){
		String titl=null, writ=null, publ=null, sort=null;
		if(st1!=null&&!sk1.isBlank()) {
			if(st1.equals("btitl")) titl=sk1;
			if(st1.equals("bwrit")) writ=sk1;
			if(st1.equals("bpubl")) publ=sk1;
			if(st1.equals("bsort")) sort=sk1;
		}
		if(st2!=null&&!sk2.isBlank()) {
			if(st2.equals("btitl")) titl=sk2;
			if(st2.equals("bwrit")) writ=sk2;
			if(st2.equals("bpubl")) publ=sk2;
			if(st2.equals("bsort")) sort=sk2;
		}
		if(st3!=null&&!sk3.isBlank()) {
			if(st3.equals("btitl")) titl=sk3;
			if(st3.equals("bwrit")) writ=sk3;
			if(st3.equals("bpubl")) publ=sk3;
			if(st3.equals("bsort")) sort=sk3;
		}
		if(st4!=null&&!sk4.isBlank()) {
			if(st4.equals("btitl")) titl=sk4;
			if(st4.equals("bwrit")) writ=sk4;
			if(st4.equals("bpubl")) publ=sk4;
			if(st4.equals("bsort")) sort=sk4;
		}
		
		Page<Bk> books=bkRepository.findByMultipleCriteria(titl,writ,publ,sort,pageable);
		return books.map(this::convertEntityToDTO);

	}
}