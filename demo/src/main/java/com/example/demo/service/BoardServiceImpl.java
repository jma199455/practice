package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.example.demo.dto.BoardDto;
import com.example.demo.mapper.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService{

	@Autowired
	BoardMapper boardMapper;

	@Override
	public List<BoardDto> selectBoardList() throws Exception {
		
		return boardMapper.selectBoardList();
	}

	@Override
	public int insertBoard(BoardDto board) throws Exception {
		return boardMapper.insertBoard(board);

	}

	@Override
	public BoardDto getDetail(int boardId) throws Exception {
		boardMapper.updateHitCount(boardId);
		return boardMapper.getDetailBoard(boardId);
	}


	@Override
	public int updateBoard(BoardDto board) throws Exception {
	  return boardMapper.updateBoard(board);
	}


    
}
