package com.example.demo.dto;

import lombok.Data;

@Data
public class BoardDto {

	private int rm;
	private int boardId;
	private String title;
	private String contents;
	private int hitCnt;
	private String createdAt;
	private String creatorId;
	private String updatedAt;
	private String updaterId;  

}
