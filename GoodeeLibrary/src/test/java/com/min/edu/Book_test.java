package com.min.edu;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.min.edu.model.book.IBookDao;
import com.min.edu.vo.BookVo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class Book_test {

	@Autowired
	private ApplicationContext context;
	
	@Autowired
	private SqlSessionTemplate session;
	
	@Autowired
	private IBookDao dao;
	
	@Test
	public void test() {
	
		//assertNotNull(context);
		//assertNotNull(session);
		
		//훼손 도서 목록 조회
//		assertNotNull(dao.damagedBookList(4)); 
//		System.out.println(dao.damagedBookList(4));
		
		//미훼손 도서 목록 조회
//		assertNotNull(dao.undamagedBookList());
//		System.out.println(dao.undamagedBookList(1));
		
		BookVo vo = new BookVo();
		vo.setTitle("자바");
		List<BookVo> lists =  dao.bookList(vo);
		for (BookVo bookVo : lists) {
			System.out.println(bookVo.toString());
		}
		
		
	}

}
