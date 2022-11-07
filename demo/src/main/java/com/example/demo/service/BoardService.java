package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.BoardDto;
import com.example.demo.dto.SearchDto;

public interface BoardService {

    public List<BoardDto> selectBoardList(SearchDto params) throws Exception;
    public int count(SearchDto search) throws Exception;
    public int insertBoard(BoardDto board) throws Exception;
    public BoardDto getDetail(int boardId) throws Exception;
    public int updateBoard(BoardDto board) throws Exception;
    public int deleteBoard(int boardId) throws Exception;
    
}
