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
		assertNotNull(context);
//		assertNotNull(session);
		
//		BookMemberVo vo = new BookMemberVo();
//		vo.setId("USER99");
//		vo.setPassword("1234");
//		vo.setName("홍길동");
//		vo.setNickname("hong");
//		vo.setPhone("01011112222");
//		assertNotNull(dao.insertMember(vo));
	}

}
