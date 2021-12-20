package com.min.edu.model.board;

import java.util.List;
import java.util.Map;

import com.min.edu.vo.BookBoardVo;

public interface IBookBoardService {

	public int insertBoard(BookBoardVo vo);

	public int updateBoard(BookBoardVo vo);

	public int delflagBoard(Map<String, String[]> seqs);

	public int deleteBoard(Map<String, String[]> seqs);

	public BookBoardVo selectOneBoard(int seq);

	public List<BookBoardVo> selectAllBoard();

}
