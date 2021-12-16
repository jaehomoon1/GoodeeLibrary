
package com.min.edu.vo;

public class BookDetailVo {

	private String detail_seq;
	private int book_seq;
	private int loan_seq;
	private String reserve;
	private int reserve_seq;
	private int damage_seq;
	
	@Override
	public String toString() {
		return "BookDetailVo [detail_seq=" + detail_seq + ", book_seq=" + book_seq + ", loan_seq=" + loan_seq
				+ ", reserve=" + reserve + ", reserve_seq=" + reserve_seq + ", damage_seq=" + damage_seq + "]";
	}

	public BookDetailVo() {
		super();
	}
	
	public String getDetail_seq() {
		return detail_seq;
	}
	public void setDetail_seq(String detail_seq) {
		this.detail_seq = detail_seq;
	}
	public int getBook_seq() {
		return book_seq;
	}
	public void setBook_seq(int book_seq) {
		this.book_seq = book_seq;
	}
	public int getLoan_seq() {
		return loan_seq;
	}
	public void setLoan_seq(int loan_seq) {
		this.loan_seq = loan_seq;
	}
	public String getReserve() {
		return reserve;
	}
	public void setReserve(String reserve) {
		this.reserve = reserve;
	}
	public int getReserve_seq() {
		return reserve_seq;
	}
	public void setReserve_seq(int reserve_seq) {
		this.reserve_seq = reserve_seq;
	}
	public int getDamage_seq() {
		return damage_seq;
	}
	public void setDamage_seq(int damage_seq) {
		this.damage_seq = damage_seq;
	}
	
	
	
}
