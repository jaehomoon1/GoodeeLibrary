package com.min.edu.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.min.edu.model.IBookMemberService;
import com.min.edu.vo.BookMemberVo;

@Controller
public class BookMemberController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private IBookMemberService service;
	
	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public String login(@RequestParam("id") String id, @RequestParam("pw") String pw,
						HttpSession session, HttpServletResponse resp) throws IOException {
		BookMemberVo vo = new BookMemberVo();
		vo.setId(id);
		vo.setPassword(pw);
		BookMemberVo result = service.loginMember(vo);
		if(result == null) {
			resp.setContentType("text/html; charset=UTF-8");
			PrintWriter out = resp.getWriter();
			out.println("<script>alert('아이디나 비밀번호가 일치하지 않습니다.');</script>");
			out.flush();
			return "member/loginForm";
		}
		session.setAttribute("mvo", result);
		logger.info("session에 들어있는 값 : {}", session.getAttribute("mvo"));
		return "book/notice";
	}
	
	@GetMapping(value = "/loginForm.do")
	public String loginForm() {
		logger.info("loginForm으로 이동");
		return "member/loginForm";
	}
	
	@GetMapping(value = "/logout.do")
	public String logout(HttpSession session) {
		session.invalidate();
		logger.info("세션 Cleanup");
		return "book/notice";
	}
	
	@GetMapping(value = "/signupForm.do")
	public String signupForm() {
		logger.info("signupForm 이동");
		return "member/signupForm";
	}
	
}
