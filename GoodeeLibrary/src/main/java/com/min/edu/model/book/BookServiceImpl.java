package com.min.edu.model.book;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.min.edu.vo.BookVo;

@Service
public class BookServiceImpl implements IBookService {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private IBookDao dao;
	
	@Override
	public List<BookVo> undamagedBookList() {
		logger.info("BookServiceImpl 미훼손 목록 조회");
		return dao.undamagedBookList();
	}

	@Override
	public List<BookVo> damagedBookList() {
		logger.info("BookServiceImpl 훼손 목록 조회");
		return dao.undamagedBookList();
	}

	@Override
	public int insertBook(BookVo vo) {
		logger.info("BookServiceImpl 책등록");
		return dao.insertBook(vo);
	}

	@Override
	public List<BookVo> bookList(BookVo vo) {
		logger.info("BookServiceImpl 책검색");
		return dao.bookList(vo);
	}



}
