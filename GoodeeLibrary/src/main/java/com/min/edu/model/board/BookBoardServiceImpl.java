package com.min.edu.model.board;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.min.edu.model.board.IBookBoardDao;
import com.min.edu.vo.BookBoardVo;
import com.min.edu.vo.PagingVo;

@Service
public class BookBoardServiceImpl implements IBookBoardService {

	@Autowired
	private IBookBoardDao answerboardDao;
	
	@Override
	public int insertBoard(BookBoardVo vo) {
		
		return answerboardDao.insertBoard(vo);
	}

	@Override
	public int updateBoard(BookBoardVo vo) {
		
		return answerboardDao.updateBoard(vo);
	}

	@Override
	public int delflagBoard(Map<String, String[]> seqs) {
		
		return answerboardDao.delflagBoard(seqs);
	}

	@Override
	public int deleteBoard(Map<String, String[]> seqs) {
		
		return answerboardDao.deleteBoard(seqs);
	}

	@Override
	public BookBoardVo selectOneBoard(int board_seq) {
		
		return answerboardDao.selectOneBoard(board_seq);
	}

	@Override
	public List<BookBoardVo> selectAllBoard() {
		
		return answerboardDao.selectAllBoard();
	}

	
//	페이징 처리
	
	@Override
	public List<BookBoardVo> selectPaging(PagingVo paging) {
		return answerboardDao.selectPaging(paging);
	}

	@Override
	public int selectTotalPaging() {
		return answerboardDao.selectTotalPaging();
	}
	
}
