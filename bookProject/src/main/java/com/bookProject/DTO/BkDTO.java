package com.bookProject.DTO;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class BkDTO {
	private int bid;
	@NotEmpty(message="필수 기재 사항")
	private String btitl;
	private String bsubt;
	@Min(value=1, message="시리즈가 아니면 1을 입력하세요")
	private int bvolu;
	private String bwrit;
	private String btran;
	private String bkeyw;
	private String bpubl;
	private int bpage;
	private String bdate;
	private int bpric;
	private String bsort;
	private String bcode;
	private String bcont;
	private String burl;
	private MultipartFile bimg;
}
