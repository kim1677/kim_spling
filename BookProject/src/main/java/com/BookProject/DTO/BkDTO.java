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
//	private String bsubt;
//	private int bvolu;
//	private String bwrit;
//	private String btran;
//	private String bkeyw;
//	private String bpubl;
//	private int bpage;
//	private String bdate;
//	private int bpric;
//	private String bsort;
//	private String bcode;
//	private String bcont;
	private MultipartFile bimg;
	
}
