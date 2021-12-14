package com.min.edu;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.min.edu.model.IBookMemberDao;
import com.min.edu.vo.BookMemberVo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class MemberTest {

	@Autowired
	private ApplicationContext context;
	
	@Autowired
	private SqlSessionTemplate session;
	
	@Autowired
	private IBookMemberDao dao;
	
	@Test
	public void test() {
//		assertNotNull(context);
//		assertNotNull(session);
		
//		//회원추가
//		BookMemberVo vo = new BookMemberVo();
//		vo.setId("USER99");
//		vo.setPassword("1234");
//		vo.setName("홍길동");
//		vo.setNickname("hong");
//		vo.setPhone("01011112222");
//		assertNotNull(dao.insertMember(vo));
		
//		//로그인
//		BookMemberVo vo = new BookMemberVo();
//		vo.setId("USER01");
//		vo.setPassword("4321");
//		assertNotNull(dao.loginMember(vo));
		
//		//회원삭제(delflag)
//		assertEquals(dao.delflagMember(3), 1); 
		
//		//비밀번호 변경
//		BookMemberVo vo = new BookMemberVo();
//		vo.setMember_seq(3);
//		vo.setPassword("4321");
//		assertEquals(dao.changeMemberPw(vo), 1);

//		BookMemberVo vo = new BookMemberVo();
//		vo.setId("USER99");
//		vo.setPassword("1234");
//		vo.setName("홍길동");
//		vo.setNickname("hong");
//		vo.setPhone("01011112222");
//		assertNotNull(dao.insertMember(vo));
	}

}
