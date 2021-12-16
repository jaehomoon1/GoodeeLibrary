package com.min.edu;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.min.edu.model.IBookMemberDao;
import com.min.edu.model.IUseLibraryDao;
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
	@Autowired
	private IUseLibraryDao uldao;
	
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
		
		// 대출중인지 확인
//		assertEquals(5, uldao.checkDetailSeq(1));
//		int n = uldao.checkDetailSeq(1);
//		assertNotNull(uldao.checkLoan(n));
//		uldao.checkLoan(n);
		
//		// 도서 대출하기
//		Map<String, Object> map1 = new HashMap<String, Object>();
//		map1.put("seq", 3);
//		assertEquals(1, uldao.insertLoan(map1));
//		Map<String, Object> map2 = new HashMap<String, Object>();
//		map2.put("book_seq", 1);
//		assertEquals(1, uldao.insertBookDetail(map2));
		
//		// 도서 예약하기
//		Map<String, Object> map1 = new HashMap<String, Object>();
//		map1.put("seq", 24);
//		assertEquals(1, uldao.insertReservation(map1));
//		assertEquals(1, uldao.updateDetailR((int) map1.get("seq")));
		
		// 회원이 대출한 도서목록
		assertNotNull(uldao.memberLoanList("USER01"));
		
	}

}
