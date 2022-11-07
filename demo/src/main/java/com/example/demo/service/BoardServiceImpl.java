package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.BoardDto;
import com.example.demo.dto.SearchDto;
import com.example.demo.mapper.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService{

	@Autowired
	BoardMapper boardMapper;

	@Override
	public List<BoardDto> selectBoardList(SearchDto params) throws Exception {
		
		// 게시글 수
		int count  = boardMapper.count(params);

		return boardMapper.selectBoardList(params);
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

	@Override
	public int deleteBoard(int boardId) throws Exception {
		return boardMapper.deleteBoard(boardId);
	}

	@Override
	public int count(SearchDto search) throws Exception {
		return boardMapper.count(search);
	}

	


    
}
