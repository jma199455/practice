package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.BoardDto;

public interface BoardService {

    public List<BoardDto> selectBoardList() throws Exception;
    public int insertBoard(BoardDto board) throws Exception;
    public BoardDto getDetail(int boardId) throws Exception;
    public int updateBoard(BoardDto board) throws Exception;
}
