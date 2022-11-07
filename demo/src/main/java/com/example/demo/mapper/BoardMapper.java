package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.dto.BoardDto;
import com.example.demo.dto.SearchDto;

@Mapper
public interface BoardMapper {

    public List<BoardDto> selectBoardList(@Param("params") SearchDto params) throws Exception;
    public int insertBoard(BoardDto board) throws Exception;
    public int updateHitCount(int boardId) throws Exception;
    public BoardDto getDetailBoard(int boardId) throws Exception;
    public int updateBoard(BoardDto board) throws Exception;
    public int deleteBoard(int boardId) throws Exception;

    public int count(@Param("params") SearchDto params) throws Exception;


}
