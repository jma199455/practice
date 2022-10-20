package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.dto.BoardDto;

@Mapper
public interface BoardMapper {

    public List<BoardDto> selectBoardList() throws Exception;
    public int insertBoard(BoardDto board) throws Exception;
    public int updateHitCount(int boardId) throws Exception;
    public BoardDto getDetailBoard(int boardId) throws Exception;
    public int updateBoard(BoardDto board) throws Exception;
    public int deleteBoard(int boardId) throws Exception;

}
