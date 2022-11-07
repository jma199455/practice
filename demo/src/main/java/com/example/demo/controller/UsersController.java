package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dto.SearchDto;
import com.example.demo.dto.UsersVO;
import com.example.demo.service.BoardService;
import com.example.demo.service.UsersService;

@Controller
public class UsersController {
    
    @Autowired
    private UsersService usersService;

    @Autowired
    private BoardService boardService;


    @RequestMapping("/login")
    public ModelAndView login() throws Exception {
      ModelAndView mv = new ModelAndView("login/loginForm");
      return mv;
    }

    // 로그인 처리하는 부분
    @RequestMapping(value="loginCheck",method=RequestMethod.POST)
    public ModelAndView loginCheck(HttpSession session,UsersVO usersVO, HttpServletRequest request, HttpServletResponse response, @ModelAttribute("params") SearchDto params) throws Exception{
        String returnURL = "";
        ModelAndView mv = new ModelAndView();

        if ( session.getAttribute("login") != null ){
            // 기존에 login이란 세션 값이 존재한다면
            session.removeAttribute("login"); // 기존값을 제거해 준다.
        }

        // 로그인이 성공하면 UsersVO 객체를 반환함.
        UsersVO vo = usersService.getUser(usersVO);
        //System.out.println("vo ==================> " + vo);
        if ( vo != null ){ // 로그인 성공
            session.setAttribute("login", vo); // 세션에 login인이란 이름으로 UsersVO 객체를 저장해 놈.
            System.out.println("로그인 성공");
            //mv.addObject("list",boardService.selectBoardList());
            UsersVO data = usersService.getUserInfo(usersVO);
            mv.addObject("data", data);
            mv.setViewName("board/boardList"); // 로그인 성공시 메인페이지로 이동하고
        }else { // 로그인에 실패한 경우
            System.out.println("로그인 실패");
            mv.setViewName("login/loginForm");
        }
            
        return mv; // 위에서 설정한 returnURL 을 반환해서 이동시킴
    }

    /*
    // 로그인 처리하는 부분
    @RequestMapping(value="loginCheck",method=RequestMethod.POST)
    public String loginCheck(HttpSession session,UsersVO usersVO, HttpServletRequest request) throws Exception{
        String returnURL = "";
        if ( session.getAttribute("login") != null ){
            // 기존에 login이란 세션 값이 존재한다면
            session.removeAttribute("login"); // 기존값을 제거해 준다.
        }

        System.out.println(request.getParameter("id"));
        System.out.println(request.getParameter("pw"));

        // 로그인이 성공하면 UsersVO 객체를 반환함.
        UsersVO vo = usersService.getUser(usersVO);
        System.out.println("vo ==================> " + vo);
        if ( vo != null ){ // 로그인 성공
            session.setAttribute("login", vo); // 세션에 login인이란 이름으로 UsersVO 객체를 저장해 놈.
            System.out.println("로그인 성공");
            returnURL = "redirect:/board/boardList"; // 로그인 성공시 메인페이지로 이동하고
        }else { // 로그인에 실패한 경우
            System.out.println("로그인 실패");
            returnURL = "redirect:/login"; // 로그인 폼으로 다시 가도록 함
        }
          
        return returnURL; // 위에서 설정한 returnURL 을 반환해서 이동시킴
    }
    */

    
    // 로그아웃 하는 부분
    @RequestMapping(value="/logout")
    public String logout(HttpSession session) {
        session.invalidate(); // 세션 초기화
        return "redirect:/login"; // 로그아웃 후 로그인화면으로 이동
    }    
    
}
