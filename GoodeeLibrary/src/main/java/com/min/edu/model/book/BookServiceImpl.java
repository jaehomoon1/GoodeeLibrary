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
	public List<BookVo> undamagedBookList(int seq) {
		logger.info("BookServiceImpl 미훼손 목록 조회");
		return dao.undamagedBookList(seq);
	}

	@Override
	public List<BookVo> damagedBookList(int seq) {
		logger.info("BookServiceImpl 훼손 목록 조회");
		return dao.undamagedBookList(seq);
	}



}
