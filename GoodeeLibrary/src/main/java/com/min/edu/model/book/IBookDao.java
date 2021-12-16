package com.min.edu.model.book;

import java.util.List;

import com.min.edu.vo.BookVo;

public interface IBookDao {

	public List<BookVo> undamagedBookList(int seq);
	public List<BookVo> damagedBookList(int seq);
	
}
