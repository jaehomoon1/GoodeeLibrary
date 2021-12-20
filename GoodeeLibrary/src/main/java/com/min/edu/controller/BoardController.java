package com.min.edu.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	public ModelAndView detailBoard(@RequestParam(required=false, defaultValue="0") int seq) {
		logger.info("BoardController 상세페이지 detailBoard : {}", seq);
		ModelAndView mav = new ModelAndView();
		BookBoardVo vo = service.selectOneBoard(seq);
		mav.setViewName("report/detailBoard");
		mav.addObject("avo", vo);
		return mav;
	}

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
//	@RequestMapping(value="/detailBoard.do", method=RequestMethod.GET )
//	public ModelAndView detailBoard(int seq) {
//		logger.info("BoardController 상세페이지 detailBoard : {}", seq); // {}를 해줘야 seq 값이 안에 들어감
//		ModelAndView mav = new ModelAndView();
//		// 값과 이등 jsp를 같이 mav 객체에 담아준다
//		AnswerboardVo vo = answerboardServiceImpl.selectOneBoard(seq);
//		mav.setViewName("detailBoard");
//		mav.addObject("avo", vo);
//		return mav;
//	}
	
//	@RequestMapping(value="/modifyBoard.do", method=RequestMethod.GET )
//	public String modifyBoard(Answerboard_VO vo) {
//		logger.info("BoardController modifyBoard : {}", vo); 
//		answerboardServiceImpl.updateBoard(vo);
//		return "redirect:/boardList.do";
//	}
	
	
}
