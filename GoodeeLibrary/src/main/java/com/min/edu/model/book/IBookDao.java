package com.min.edu.model.book;

import java.util.List;

import com.min.edu.vo.BookVo;

public interface IBookDao {

	public List<BookVo> undamagedBookList();
	public List<BookVo> damagedBookList();
	public int insertBook(BookVo vo);
	public List<BookVo> bookList(BookVo vo);
	public List<BookVo> allBookList();
	
}
