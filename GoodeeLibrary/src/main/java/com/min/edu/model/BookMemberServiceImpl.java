package com.min.edu.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.min.edu.vo.BookMemberVo;

@Service
public class BookMemberServiceImpl implements IBookMemberService {

	@Autowired
	private IBookMemberDao dao;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());


	@Override
	public int insertMember(BookMemberVo vo) {
		return dao.insertMember(vo);
	}

	@Override
	public int delflagMember(int seq) {
		return dao.delflagMember(seq);
	}

	@Override
	public int changeMemberPw(BookMemberVo vo) {
		return dao.changeMemberPw(vo);
	}

	@Override
	public BookMemberVo loginMember(BookMemberVo vo) {
		return dao.loginMember(vo);
	}
	
}
