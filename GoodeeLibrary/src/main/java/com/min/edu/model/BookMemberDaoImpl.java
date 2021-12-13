package com.min.edu.model;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.min.edu.vo.BookMemberVo;

@Repository
public class BookMemberDaoImpl implements IBookMemberDao {
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private final String NS = "com.min.edu.model.MemberDaoImpl.";


	@Override
	public int insertMember(BookMemberVo vo) {
		return sqlSession.insert(NS+"insertMember", vo);
	}

	@Override
	public int delflagMember(int seq) {
		return sqlSession.update(NS+"delflagMember", seq);
	}

	@Override
	public int changeMemberPw(BookMemberVo vo) {
		return sqlSession.update(NS+"changeMemberPw", vo);
	}

	@Override
	public BookMemberVo loginMember(BookMemberVo vo) {
		return sqlSession.selectOne(NS+"loginMember", vo);
	}
	
}
