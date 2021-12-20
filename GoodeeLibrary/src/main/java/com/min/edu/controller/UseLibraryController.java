package com.min.edu.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.min.edu.model.IUseLibraryService;
import com.min.edu.vo.BookLoanVo;

@Controller
public class UseLibraryController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private IUseLibraryService service;
	
	@GetMapping(value = "/checkLoan.do")
	public String checkLoan(@RequestParam int seq, Model model) {
		logger.info("UseLibraryController checkLoan 실행");
		BookLoanVo vo = null;
		
		int n = service.checkDetailSeq(seq);
		logger.info("결과 값 {}", n);
		
		if(n != 0) {
			vo = service.checkLoan(n);
		}
		model.addAttribute("loanVo", vo);
		return "library/result";
	}
	
	@GetMapping(value = "/insertLoan.do")
	public String insertLoan(Map<String, Object> map, @RequestParam int memSeq, @RequestParam int bookSeq,
							 Model model) {
		logger.info("UseLibraryController insertLoan 실행");
		map.put("seq", memSeq);
		map.put("book_seq", bookSeq);
		
		int il = service.insertLoan(map);
		int ibd = service.insertBookDetail(map);
		
		model.addAttribute("il", il);
		model.addAttribute("ibd", ibd);
		
		return "library/result";
	}
	
	@GetMapping(value = "/insertReservation.do")
	public String insertReservation(Map<String, Object> map, @RequestParam int loanSeq, Model model) {
		logger.info("UseLibraryController insertReservation 실행");
		map.put("seq", loanSeq);
		
		int ir = service.insertReservation(map);
		int udr = service.updateDetailR(loanSeq);
		
		model.addAttribute("ir", ir);
		model.addAttribute("udr", udr);
		
		return "library/result";
	}
	
	@GetMapping(value = "/memberLoanList.do")
	public String memberLoanList(Model model, @RequestParam String id) {
		logger.info("UseLibraryController memberLoanList 실행");
		
		List<BookLoanVo> lists = null;
		
		lists = service.memberLoanList(id);
		model.addAttribute("lists", lists);
		
		return "library/result";
	}

}
