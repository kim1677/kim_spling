package com.endControl.Service;

import org.springframework.stereotype.Service;

import com.Dto.ToyDestDTO;
import com.Dto.ToyInfoDTO;

@Service
public class ToyService {
	
	public ToyInfoDTO toysearch(ToyDestDTO toyDestDto) {
		ToyInfoDTO toyInfoDTO = new ToyInfoDTO();
		toyInfoDTO.setToyname("트렌스포머");
		toyInfoDTO.setToyprice(12000);
		toyInfoDTO.setToyage(6);
		toyInfoDTO.setTip("변화무쌍 변신");
		
		return toyInfoDTO;
	}
}
