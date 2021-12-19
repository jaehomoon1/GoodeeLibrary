package com.min.edu.model.book;

import java.util.List;

import com.min.edu.vo.BookVo;

public interface IBookService {

	public List<BookVo> undamagedBookList(int seq);
	public List<BookVo> damagedBookList(int seq);
	public int insertBook(BookVo vo);
}
