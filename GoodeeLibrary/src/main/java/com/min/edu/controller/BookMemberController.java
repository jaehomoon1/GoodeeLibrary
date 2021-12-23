package com.min.edu.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.min.edu.model.IBookMemberService;
import com.min.edu.vo.BookMemberVo;

@Controller
public class BookMemberController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private IBookMemberService service;
	
	
	@GetMapping(value = "/loginForm.do")
	public String loginForm() {
		logger.info("loginForm으로 이동");
		return "member/loginForm";
	}
	
	@PostMapping(value = "/loginCheckMap.do")
	@ResponseBody
	public Map<String, String> loginCheckMap(@RequestParam Map<String, Object> iMap){
		Map<String, String> map = new HashMap<String, String>();
		BookMemberVo mDto = service.loginMember(iMap);
		logger.info("MemberController loginCheckMap 로그인된 값 {}", mDto);
		if(mDto == null) {
			map.put("isc", "실패");
		}else {
			map.put("isc", "성공");
		}
		return map;
	}
	
	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public String login(@RequestParam Map<String, Object> map,
						HttpSession session) {
		logger.info("*&^*&^&*{}", map);
		BookMemberVo result = service.loginMember(map);
		session.setAttribute("mvo", result);
		logger.info("session에 들어있는 값 : {}", session.getAttribute("mvo"));
		return "book/notice";
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
	
	@PostMapping(value = "/idCheck.do")
	@ResponseBody
	public Map<String, String> idCheck(String id){
		Map<String, String> map = new HashMap<String, String>();
		boolean isc = service.idDuplicateCheck(id);
		map.put("isc", String.valueOf(isc));
		return map;
	}
	
	@PostMapping(value = "/signup.do")
	public String signup(BookMemberVo vo) {
		logger.info("signup 실행");
		boolean isc = service.insertMember(vo);
		return isc?"redirect:/loginForm.do":"redirect:/signupForm.do";
	}
	
	
	@GetMapping(value = "/memberInfo.do")
	public String memberInfo() {
		return "member/memberInfo";
	}
}
