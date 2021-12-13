package com.min.edu.model;

import com.min.edu.vo.BookMemberVo;

public interface IBookMemberDao {

	public int insertMember (BookMemberVo vo);
	
	public int delflagMember (int seq);
	
	public int changeMemberPw (BookMemberVo vo);
	
	public BookMemberVo loginMember (BookMemberVo vo);
	
}
