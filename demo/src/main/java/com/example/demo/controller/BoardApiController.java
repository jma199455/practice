package com.example.demo.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.BoardDto;
import com.example.demo.dto.SearchDto;
import com.example.demo.result.ResultBuilder;
import com.example.demo.service.BoardService;

@RestController
@RequestMapping("api/board")
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
    
    @GetMapping("boardlist")            
    public List<BoardDto> openBoardList(@ModelAttribute("params") SearchDto params) throws Exception {

      System.out.println("API 컨틀롤러 들어옴 =======> " + params);
      

      //ModelAndView mv = new ModelAndView("board/boardList");
      //UsersVO rs = (UsersVO) session.getAttribute("login");
      List<BoardDto> list = boardService.selectBoardList(params);

      //mv.addObject("list",list);
      //mv.addObject("data", rs);

      //List<BoardDto> list = boardService.selectBoardList();
      //System.out.println(list);
      return list;
    }



    // submit action으로 처리
    @PostMapping("insertBoard")
    public void insertBoard(BoardDto board, HttpServletResponse response) throws Exception {
        System.out.println(board);
        int result = boardService.insertBoard(board);
        response.sendRedirect("boardList"); // submit action으로 처리해서.. (ajax처리였으면 location.href)
    }    

    // ajax 처리
    @PostMapping("updateBoard") // 수정요청
    public int updateBoard(@RequestBody BoardDto board) throws Exception {
        System.out.println(board.getTitle());
        System.out.println("board =====> " + board);
        int result = boardService.updateBoard(board);
        return result; // 게시글 수정
    }

    // ajax callback함수처리
    @PostMapping("deleteBoard")
    public int deleteBoard(@RequestParam int boardId) throws Exception{
        return boardService.deleteBoard(boardId);
    }


}
