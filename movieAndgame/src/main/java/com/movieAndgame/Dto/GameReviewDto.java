package com.movieAndgame.Dto;

import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GameReviewDto {
	private int postId;
	
	@NotBlank(message = "제목은 꼭 입력하세요")
	private String title;
	
	private String writer;
	private String game_name;
	
	@Size(min=10, max=300, message="최소 10자 이상 작성하세요")
	private String target_post;
	
	private LocalDateTime writeDate;
}
