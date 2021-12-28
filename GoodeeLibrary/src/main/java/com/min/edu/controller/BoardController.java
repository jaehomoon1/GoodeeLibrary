package com.min.edu.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Spliterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.min.edu.model.bd.IBdService;
import com.min.edu.model.board.IBookBoardService;
import com.min.edu.vo.BookBoardVo;
import com.min.edu.vo.BookDetailVo;
import com.min.edu.vo.BookVo;
import com.min.edu.vo.PagingVo;

@Controller
public class BoardController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private IBookBoardService service;
	
	@Autowired
	private IBdService bdService;

	@RequestMapping(value = "/boardList.do", method = RequestMethod.GET)
	public String boardList(Model model, HttpServletRequest req) {
		logger.info("BoardController 전체 글 조회 boardList");
		PagingVo pvo = new PagingVo();
		List<BookBoardVo> lists = service.selectPaging(pvo);
		int n = service.selectTotalPaging();
		pvo.setTotal(n);

		if(lists != null) {
			for (BookBoardVo bVo : lists) {
				String[] bVo2 = bVo.getId().split("@");
				String bVo3 = bVo2[0];
				bVo.setId(bVo3);
			}
		}
		
		model.addAttribute("lists", lists);
		model.addAttribute("paging", pvo);
		
		return "report/boardList";
	}

	@RequestMapping(value = "/paging.do", method = RequestMethod.POST)
	public String paging(Model model, HttpServletRequest req) {
		System.out.print("index:" + req.getParameter("index"));
		
		PagingVo pvo = new PagingVo(req.getParameter("index"), 
									req.getParameter("pageStartNum"),
									req.getParameter("listCnt") );

		pvo.setTotal(service.selectTotalPaging());
		List<BookBoardVo> lists = service.selectPaging(pvo);
		
		if(lists != null) {
			for (BookBoardVo bVo : lists) {
				String[] bVo2 = bVo.getId().split("@");
				String bVo3 = bVo2[0];
				bVo.setId(bVo3);
			}
		}
		
		model.addAttribute("lists", lists);
		model.addAttribute("paging", pvo);

		System.out.println(pvo.toString());

		return "report/boardList";
	}

	@RequestMapping(value = "/detailBoard.do", method = RequestMethod.GET)
	public ModelAndView detailBoard(int board_seq) { // httpservletrequest req
//		int board_seq = Integer.parseInt(req.getParameter("board_seq"));
		logger.info("BoardController 상세페이지 detailBoard : {}", board_seq);
		ModelAndView mav = new ModelAndView();
		BookBoardVo vo = service.selectOneBoard(board_seq);
		mav.setViewName("report/detailBoard");

		String[] vo2 = vo.getId().split("@");
		String vo3 = vo2[0];
		vo.setId(vo3);
		
		mav.addObject("avo", vo);
		
		return mav;

	}

	@GetMapping("/insertBoardForm.do")
	public String insertBoardForm(Model model) {
		logger.info("BoardController 새글입력폼 insertBoardForm");
		
		return "book/insertBoard";
	}

	@PostMapping("/insertBoard.do")
	public String insertBoard(BookBoardVo vo, HttpServletResponse resp) throws IOException {
		logger.info("BoardController 새글입력 insertBoard : ", vo);
		// 얼럿 추가
		int cnt = service.insertBoard(vo);
		if(cnt == 1) {
			resp.setContentType("text/html; charset=UTF-8");
			PrintWriter out = resp.getWriter();
			out.println("<script>alert('성공적으로 새 글이 입력되었습니다'); location.href='./boardList.do'; </script>");
			out.flush();
			return null;
		}else {
			resp.setContentType("text/html; charset=UTF-8");
			PrintWriter out = resp.getWriter();
			out.println("<script>alert('새 글 입력에 실패했습니다'); location.href='./boardList.do'; </script>");
			out.flush();
			return null;
		}
	}

}

//@RequestMapping(value="/modifyBoard.do", method=RequestMethod.GET )
//public String modifyBoard(BookBoardVo vo) {
//	logger.info("BoardController modifyBoard : {}", vo); 
//	service.updateBoard(vo);
//	return "redirect:/boardList.do";
//}


//@PostMapping("/multiDel.do")
//public String multiDel(
////		String chk
//		String[] chk
////		Map<String,String> chk
////		HttpServletRequest req
////		int[] chk
//		) {
//	
//	logger.info("BoardController 다중삭제 multiDel");
//
//	Map<String, String[]> map = new HashMap<String, String[]>();
//	map.put("seqs", chk); // answerboard.xml의 foreach문 collection 값 > "seqs"
//	int cnt = answerboardServiceImpl.delflagBoard(map);
//	logger.info("Delflag 된 개수 : "+cnt);
//	return "redirect:/boardList.do"; 
//}
