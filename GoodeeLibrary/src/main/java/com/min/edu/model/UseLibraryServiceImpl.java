package com.min.edu.model;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.min.edu.vo.BookLoanVo;
import com.min.edu.vo.BookVo;

@Service
public class UseLibraryServiceImpl implements IUseLibraryService {

	@Autowired
	private IUseLibraryDao dao;
	
	@Override
	public int checkDetailSeq(int seq) {
		return dao.checkDetailSeq(seq);
	}

	@Override
	public BookLoanVo checkLoan(int seq) {
		return dao.checkLoan(seq);
	}

	@Override
	public int insertLoan(Map<String, Object> map) {
		return dao.insertLoan(map);
	}

	@Override
	public int insertBookDetail(Map<String, Object> map) {
		return dao.insertBookDetail(map);
	}

	@Override
	public int insertReservation(Map<String, Object> map) {
		return dao.insertReservation(map);
	}

	@Override
	public int updateDetailR(int seq) {
		return dao.updateDetailR(seq);
	}

	@Override
	public List<BookLoanVo> memberLoanList(String id) {
		return dao.memberLoanList(id);
	}

	@Override
	public int countBook(String title) {
		return dao.countBook(title);
	}

	@Override
	public boolean checkBookSeq(String title) {
		return dao.checkBookSeq(title);
	}

	@Override
	public List<BookVo> memberLoanBook(String id) {
		return dao.memberLoanBook(id);
	}

	@Override
	public int returnBookUpdate(int book_seq) {
		return dao.returnBookUpdate(book_seq);
	}

	

}
