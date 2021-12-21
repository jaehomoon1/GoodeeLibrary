package com.min.edu.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

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

import com.min.edu.model.board.IBookBoardService;
import com.min.edu.vo.BookBoardVo;
import com.min.edu.vo.PagingVo;

@Controller
public class BoardController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private IBookBoardService service;
	
	@RequestMapping(value="/boardList.do", method=RequestMethod.GET)
	public String boardList(Model model) {
		logger.info("BoardController 전체 글 조회 boardList");
		List<BookBoardVo> lists = service.selectAllBoard();
		model.addAttribute("lists", lists);
		return "report/boardList";
	}
	
	@RequestMapping(value="/detailBoard.do", method=RequestMethod.GET )
	public ModelAndView detailBoard(int board_seq) { //httpservletrequest req
//		int board_seq = Integer.parseInt(req.getParameter("board_seq"));
		logger.info("BoardController 상세페이지 detailBoard : {}", board_seq);
		ModelAndView mav = new ModelAndView();
		BookBoardVo vo = service.selectOneBoard(board_seq);
		mav.setViewName("report/detailBoard");
		mav.addObject("avo", vo);
		return mav;
		
	}

	
	/*
	 * // 페이징 처리
	 * 
	 * @RequestMapping(value ="/paging.do" , method =
	 * {RequestMethod.POST,RequestMethod.GET}) public String paging(Model
	 * model,HttpServletRequest request) { PagingVo paging = new PagingVo(
	 * request.getParameter("index"), request.getParameter("pageStartNum"),
	 * request.getParameter("listCnt") );
	 * 
	 * paging.setTotal(service.selectTotalPaging()); List<BookBoardVo> lists =
	 * service.selectPaging(paging);
	 * 
	 * model.addAttribute("lists",lists); model.addAttribute("paging", paging);
	 * logger.info("페이징 DTO 값 :{}",paging.toString()); return
	 * "redirect:/report/boardList.do"; }
	 */
   
	
//	@PostMapping("/multiDel.do")
//	public String multiDel(
////			String chk
//			String[] chk
////			Map<String,String> chk
////			HttpServletRequest req
////			int[] chk
//			) {
//		
//		logger.info("BoardController 다중삭제 multiDel");
//
//		Map<String, String[]> map = new HashMap<String, String[]>();
//		map.put("seqs", chk); // answerboard.xml의 foreach문 collection 값 > "seqs"
//		int cnt = answerboardServiceImpl.delflagBoard(map);
//		logger.info("Delflag 된 개수 : "+cnt);
//		return "redirect:/boardList.do"; 
//	}
//	
//	@GetMapping("/insertBoardForm.do")
//	public String insertBoardForm() {
//		logger.info("BoardController 새글입력폼 insertBoardForm");
//		return "insertBoard";
//	}
//	
//	@PostMapping("/insertBoard.do")
//	public String insertBoard(AnswerboardVo vo, HttpServletResponse resp) throws IOException {
//		logger.info("BoardController 새글입력 insertBoard : ", vo);
//		// 얼럿 추가
//		int cnt = answerboardServiceImpl.insertBoard(vo);
//		if(cnt == 1) {
//			resp.setContentType("text/html; charset=UTF-8");
//			PrintWriter out = resp.getWriter();
//			out.println("<script>alert('성공적으로 새 글이 입력되었습니다'); location.href='./boardList.do'; </script>");
//			out.flush();
//			return null;
//		}else {
//			resp.setContentType("text/html; charset=UTF-8");
//			PrintWriter out = resp.getWriter();
//			out.println("<script>alert('새 글 입력에 실패했습니다'); location.href='index.jsp'; </script>");
//			out.flush();
//			return null;
//		}
//	}
//	
//	@RequestMapping(value="/modifyBoard.do", method=RequestMethod.GET )
//	public String modifyBoard(Answerboard_VO vo) {
//		logger.info("BoardController modifyBoard : {}", vo); 
//		answerboardServiceImpl.updateBoard(vo);
//		return "redirect:/boardList.do";
//	}
	
	
}
