package com.example.demo.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.BoardDto;
import com.example.demo.result.ResultBuilder;
import com.example.demo.result.ResultVO;
import com.example.demo.service.BoardService;

@RestController
@RequestMapping("board")
public class BoardApiController {

    @Autowired
    private BoardService boardService;
  
	@Autowired
	private ResultBuilder resultBuilder;
    
    /*  
    @GetMapping("boardList")
    public ResultVO openBoardList() throws Exception {
      //List<BoardDto> list = boardService.selectBoardList();     //service를 이용하여 게시판 목록을 데이터베이스에서 조회한다.
      return resultBuilder.resultForObjectAll(boardService.selectBoardList());
    }   
    */
    
    @PostMapping("insertBoard")
    public void insertBoard(BoardDto board, HttpServletResponse response) throws Exception {
        System.out.println(board);
        int result = boardService.insertBoard(board);
        response.sendRedirect("boardList");
    }    

    @PostMapping("updateBoard") // 수정요청
    public int updateBoard(@RequestBody BoardDto board) throws Exception {
        System.out.println(board.getTitle());
        System.out.println("board =====> " + board);
        int result = boardService.updateBoard(board);
        return result; // 게시글 수정
    }

    @PostMapping("deleteBoard")
    public int deleteBoard(@RequestParam int boardId) throws Exception{
        return boardService.deleteBoard(boardId);
    }


}
