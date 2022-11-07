package com.example.demo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dto.BoardDto;
import com.example.demo.dto.SearchDto;
import com.example.demo.dto.UsersVO;
import com.example.demo.service.BoardService;
import com.example.demo.service.UsersService;

@Controller
@RequestMapping("board")
public class BoardViewController {
    
    @Autowired
    private BoardService boardService;

    @Autowired UsersService usersService;

    @RequestMapping("boardList")
    public ModelAndView openBoardList(HttpSession session, @ModelAttribute("params") SearchDto params) throws Exception {

      System.out.println("뷰 Controller ==============>" + params);
      ModelAndView mv = new ModelAndView("board/boardList");

      UsersVO rs = (UsersVO) session.getAttribute("login");
      mv.addObject("data", rs);

      //mv.addObject("list",boardService.selectBoardList(search));
      //List<BoardDto> list = boardService.selectBoardList();
      //System.out.println(list);
      return mv;
    }

    @RequestMapping("openBoardWrite")
    public ModelAndView openBoardWrite() {
      ModelAndView mv = new ModelAndView("board/boardWrite");
      mv.addObject("data", new BoardDto()); // dto를 model객체로 view에 보내지 않아도 가능
      return mv;
    }

    //@RequestParam  (html 파일 href 값도 변경해줘야함 ?boardId=)
    /*  
    @GetMapping("openBoardDetail")
    public ModelAndView openBoardDetail(@RequestParam int boardId) throws Exception {
      ModelAndView mv = new ModelAndView("board/boardDetail");
      BoardDto board = boardService.getDetail(boardId);
      mv.addObject("board",board);
      return mv;

    }
    */

    //@PathVariable 사용 
    @GetMapping("openBoardDetail/{boardId}")
    public ModelAndView openBoardDetail(@PathVariable int boardId) throws Exception {
      ModelAndView mv = new ModelAndView("board/boardDetail");
      BoardDto board = boardService.getDetail(boardId);
      mv.addObject("board",board);
      return mv;

    }


}