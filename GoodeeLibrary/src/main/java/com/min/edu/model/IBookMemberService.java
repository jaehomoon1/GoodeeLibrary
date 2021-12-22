package com.min.edu.model;

import java.util.Map;

import com.min.edu.vo.BookMemberVo;

public interface IBookMemberService {

	public boolean insertMember (BookMemberVo vo);
	
	public int delflagMember (int seq);
	
	public int changeMemberPw (BookMemberVo vo);
	
	public BookMemberVo loginMember (Map<String, Object> map);
	
	public String selStringPw(String id);
	
	public BookMemberVo enLogin(String id);
	
	public boolean idDuplicateCheck(String id);
	
}
