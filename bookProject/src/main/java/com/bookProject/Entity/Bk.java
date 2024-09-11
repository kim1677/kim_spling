package com.bookProject.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="bookinfo3")
public class Bk {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long bid;
	private String btitl;
	private String bsubt;
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
	@Column(columnDefinition = "TEXT")
	private String bcont;
	private String burl;
	private String filename;
}
