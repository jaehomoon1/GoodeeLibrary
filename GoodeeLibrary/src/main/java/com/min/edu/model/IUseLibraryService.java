package com.min.edu.model;

import java.util.List;
import java.util.Map;

import com.min.edu.vo.BookLoanVo;
import com.min.edu.vo.BookVo;

public interface IUseLibraryService {

	public int checkDetailSeq(int seq);
	public BookLoanVo checkLoan(int seq);
	
	public int insertLoan(Map<String, Object> map);
	public int insertBookDetail(Map<String, Object> map);
	
	public int insertReservation(Map<String, Object> map);
	public int updateDetailR(int seq);
	
	public List<BookLoanVo> memberLoanList(String id);
	
	public int countBook(String title);

	public boolean checkBookSeq(String title);
	
	public List<BookVo> memberLoanBook(String id);

	public int returnBookUpdate(int book_seq);
	
}
