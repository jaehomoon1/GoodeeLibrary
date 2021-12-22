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
	public List<BookVo> undamagedBookList() {
		logger.info("BookDaoImpl 미훼손 도서 목록 조회");
		return sqlSession.selectList(NS+"undamagedBookList");
	}

	@Override
	public List<BookVo> damagedBookList() {
		logger.info("BookDaoImpl 훼손 도서 목록 조회");
		return sqlSession.selectList(NS+"damagedBookList");
	}

	@Override
	public int insertBook(BookVo vo) {
		logger.info("BookDaoImpl 책 등록 {}"+ vo);
		return sqlSession.insert(NS+"insertBook",vo);
	}

	@Override
	public List<BookVo> bookList(BookVo vo) {
		logger.info("BookDaoImpl 책 검색 {}", vo);
		return sqlSession.selectList(NS+"bookList",vo);
	}

}
