package com.min.edu.model;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.min.edu.vo.BookLoanVo;

@Repository
public class UseLibraryDaoImpl implements IUseLibraryDao {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private final String NS = "com.min.edu.model.UseLibraryDaoImpl.";

	@Override
	public int checkDetailSeq(int seq) {
		logger.info("UseLibraryDaoImpl checkDetailSeq 실행 : {}", seq);
		return sqlSession.selectOne(NS+"checkDetailSeq", seq);
	}

	@Override
	public BookLoanVo checkLoan(int seq) {
		logger.info("UseLibraryDaoImpl checkLoan 실행 : {}", seq);
		return sqlSession.selectOne(NS+"checkLoan", seq);
	}

	@Override
	public int insertLoan(Map<String, Object> map) {
		logger.info("UseLibraryDaoImpl insertLoan 실행 : {}", map);
		return sqlSession.insert(NS+"insertLoan", map);
	}

	@Override
	public int insertBookDetail(Map<String, Object> map) {
		logger.info("UseLibraryDaoImpl insertBookDetail 실행 : {}", map);
		return sqlSession.insert(NS+"insertBookDetail", map);
	}

	@Override
	public int insertReservation(Map<String, Object> map) {
		logger.info("UseLibraryDaoImpl insertReservation 실행 : {}", map);
		return sqlSession.insert(NS+"insertReservation", map);
	}

	@Override
	public int updateDetailR(int seq) {
		logger.info("UseLibraryDaoImpl updateDetailR 실행 : {}", seq);
		return sqlSession.update(NS+"updateDetailR", seq);
	}

	@Override
	public List<BookLoanVo> memberLoanList(String id) {
		logger.info("UseLibraryDaoImpl memberLoanList 실행 : {}", id);
		return sqlSession.selectList(NS+"memberLoanList", id);
	}

}
