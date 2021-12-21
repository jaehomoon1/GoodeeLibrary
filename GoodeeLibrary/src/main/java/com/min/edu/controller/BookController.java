package com.min.edu.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.min.edu.model.bd.IBdService;
import com.min.edu.model.book.IBookService;
import com.min.edu.vo.BookVo;

@Controller
public class BookController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private IBookService bookService;
	
	@RequestMapping(value="/damagedBook.do", method= {RequestMethod.POST, RequestMethod.GET})
	public String damagedBook() {
		logger.info("BookController 훼손 도서 신고 실행");
//		bdService
		return "report/damagedBook";
	}
	
	@RequestMapping(value="/damagedBookList.do", method= {RequestMethod.GET})
	public String damagedBookList(Model model) {
		logger.info("BookController 훼손 도서 목록 실행");
		List<BookVo> blist = bookService.damagedBookList();
		model.addAttribute("blist", blist);
		return "report/damagedBookList";
	}

	@RequestMapping(value="/notice.do", method=RequestMethod.GET)
	public String notice() {
		logger.info("BookController 공지사항 실행");
		return "book/notice";
	}
	
}
