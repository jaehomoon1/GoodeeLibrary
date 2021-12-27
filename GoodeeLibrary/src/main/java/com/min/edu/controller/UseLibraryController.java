package com.min.edu.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.min.edu.model.IUseLibraryService;
import com.min.edu.vo.BookLoanVo;
import com.min.edu.vo.BookMemberVo;
import com.min.edu.vo.BookVo;

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
	
	@PostMapping(value = "/insertLoan.do")
	public String insertLoan(Map<String, Object> map, String title, HttpSession session) {
		logger.info("UseLibraryController insertLoan 실행");
		BookMemberVo vo = (BookMemberVo) session.getAttribute("mvo");
		map.put("seq", vo.getMember_seq());
		map.put("title", title);
		
		service.insertLoan(map);
		service.insertBookDetail(map);
		
		return "book/loanEnd";
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
	
	@PostMapping(value = "/bookLoanForm.do")
	public String bookdetail(String thumbnail ,String title ,String contents,
			String datetime, String isbn, String price,
			String publisher, String authors ,Model model) {

		int n = service.countBook(title);
		boolean checkBookSeq = service.checkBookSeq(title);
		
		model.addAttribute("authors",authors);
		model.addAttribute("publisher",publisher);
		model.addAttribute("datetime",datetime);
		model.addAttribute("isbn",isbn);
		model.addAttribute("price",price);
		model.addAttribute("contents",contents);
		model.addAttribute("thumbnail",thumbnail);
		model.addAttribute("title",title);
		model.addAttribute("countBook", n);
		model.addAttribute("checkBookSeq", checkBookSeq);
		
		
		return "book/bookLoan";
	}
	
	@GetMapping(value = "/returnBookForm.do")
	public String returnBookForm(HttpSession session, Model model) {
		BookMemberVo vo = (BookMemberVo) session.getAttribute("mvo");
		List<BookVo> lists = service.memberLoanBook(vo.getId());
		
		model.addAttribute("lists", lists);
		
		return "book/returnBookForm";
	}
	
	@PostMapping(value = "/returnBook.do")
	public String returnBook(int book_seq) {
		service.returnBookUpdate(book_seq);
		return "redirect:/returnBookForm.do";
	}

}
