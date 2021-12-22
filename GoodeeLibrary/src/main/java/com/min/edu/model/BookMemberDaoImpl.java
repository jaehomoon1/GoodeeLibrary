package com.min.edu.model;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import com.min.edu.vo.BookMemberVo;

@Repository
public class BookMemberDaoImpl implements IBookMemberDao {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	private final String NS = "com.min.edu.model.MemberDaoImpl.";

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	

	@Override
	public boolean insertMember(BookMemberVo vo) {
		String enPw = passwordEncoder.encode(vo.getPassword());
		vo.setPassword(enPw);
		int n = sqlSession.insert(NS+"insertMember", vo);
		return n>0?true:false;
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
	public BookMemberVo loginMember(Map<String, Object> map) {
		String dbPw = sqlSession.selectOne(NS+"selStringPw", map.get("id"));
		BookMemberVo bmvo = null;
		
		if(passwordEncoder.matches((String)map.get("password"), dbPw)) {
			bmvo = sqlSession.selectOne(NS+"enLogin", map.get("id"));
		}
		return bmvo;
	}

	@Override
	public String selStringPw(String id) {
		return sqlSession.selectOne(NS+"selStringPw", id);
	}

	@Override
	public BookMemberVo enLogin(String id) {
		return sqlSession.selectOne(NS+"enLogin", id);
	}

	@Override
	public boolean idDuplicateCheck(String id) {
		int n = sqlSession.selectOne(NS+"idDuplicateCheck", id);
		return n>0?true:false;
	}
	
}
