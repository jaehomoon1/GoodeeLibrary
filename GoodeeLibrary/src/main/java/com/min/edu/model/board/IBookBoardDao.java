package com.min.edu.model.board;

import java.util.List;
import java.util.Map;

import com.min.edu.vo.BookBoardVo;
import com.min.edu.vo.PagingVo;

public interface IBookBoardDao {

	public int insertBoard(BookBoardVo vo);

	public int updateBoard(BookBoardVo vo);

	public int delflagBoard(Map<String, String[]> seqs);

	public int deleteBoard(Map<String, String[]> seqs);

	public BookBoardVo selectOneBoard(int board_seq);

	public List<BookBoardVo> selectAllBoard();

//	페이징 처리
	public List<BookBoardVo> selectPaging(PagingVo paging);
	public int selectTotalPaging();
}
