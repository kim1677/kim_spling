package com.BookProject.DTO;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BkDTO {
	private int bid;
	private String btitl;
	private String burl;
	private MultipartFile bimg;
	
}
