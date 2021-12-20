package com.min.edu.model.board;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.min.edu.vo.BookBoardVo;

@Repository
public class BookBoardDaoImpl implements IBookBoardDao {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	private final String NS = "com.min.edu.model.board.BookBoardDaoImpl.";
	
//	root-context > sqlSessionTemplate
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public int insertBoard(BookBoardVo vo) {
		logger.info("ROOT글 새 글 등록");
		return sqlSession.insert(NS+"insertBoard", vo);
	}

	@Override
	public int updateBoard(BookBoardVo vo) {
		logger.info("글 수정");
		return sqlSession.update(NS+"updateBoard", vo);
	}
	
	//Dynamic Query가 아닌 경우 for문을 돌려주면 됨
	@Override
	public int delflagBoard(Map<String, String[]> seqs) {
		logger.info("delflag 삭제");
		return sqlSession.delete(NS+"delflagBoard", seqs);
	}

	@Override
	public int deleteBoard(Map<String, String[]> seqs) {
		logger.info("deleteBoard 삭제");
		return sqlSession.delete(NS+"deleteBoard", seqs);
	}

	@Override
	public BookBoardVo selectOneBoard(int seq) {
		logger.info("상세 조회");
		return sqlSession.selectOne(NS+"selectOneBoard", seq);
	}

	@Override
	public List<BookBoardVo> selectAllBoard() {
		logger.info("전체 조회");
		return sqlSession.selectList(NS+"selectAllBoard");
	}

}
