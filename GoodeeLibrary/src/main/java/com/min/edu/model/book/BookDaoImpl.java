package com.min.edu.model.book;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.min.edu.vo.BookVo;

@Repository
public class BookDaoImpl implements IBookDao {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	private final String NS = "com.min.edu.model.book.BookDaoImpl.";
	
	@Override
	public List<BookVo> undamagedBookList(int seq) {
		logger.info("BookDaoImpl 미훼손 도서 목록 조회");
		return sqlSession.selectList(NS+"undamagedBookList", seq);
	}

	@Override
	public List<BookVo> damagedBookList(int seq) {
		logger.info("BookDaoImpl 훼손 도서 목록 조회");
		return sqlSession.selectList(NS+"damagedBookList", seq);
	}

}
