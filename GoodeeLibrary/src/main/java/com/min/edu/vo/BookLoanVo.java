package com.min.edu.vo;

public class BookLoanVo {

	

	private int loan_seq;
	private String loan_sday;
	private String loan_eday;
	private String loan_check;
	private int member_seq;

	public BookLoanVo() {
		super();
	}
	
	public BookLoanVo(int loan_seq, String loan_sday, String loan_eday, String loan_check, int member_seq) {
			super();
			this.loan_seq = loan_seq;
			this.loan_sday = loan_sday;
			this.loan_eday = loan_eday;
			this.loan_check = loan_check;
			this.member_seq = member_seq;
		}
	
	public int getLoan_seq() {
		return loan_seq;
	}

	public void setLoan_seq(int loan_seq) {
		this.loan_seq = loan_seq;
	}

	public String getLoan_sday() {
		return loan_sday;
	}

	public void setLoan_sday(String loan_sday) {
		this.loan_sday = loan_sday;
	}

	public String getLoan_eday() {
		return loan_eday;
	}

	public void setLoan_eday(String loan_eday) {
		this.loan_eday = loan_eday;
	}

	public String getLoan_check() {
		return loan_check;
	}

	public void setLoan_check(String loan_check) {
		this.loan_check = loan_check;
	}

	public int getMember_seq() {
		return member_seq;
	}

	public void setMember_seq(int member_seq) {
		this.member_seq = member_seq;
	}

	@Override
	public String toString() {
		return "BookLoanVo [loan_seq=" + loan_seq + ", loan_sday=" + loan_sday + ", loan_eday=" + loan_eday
				+ ", loan_check=" + loan_check + ", member_seq=" + member_seq + "]";
	}

	
}
