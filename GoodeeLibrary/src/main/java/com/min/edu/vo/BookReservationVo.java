package com.min.edu.vo;

public class BookReservationVo {

	private int reserve_seq;
	private String reserve_date;
	private int reserve_period;
	
	public BookReservationVo() {
		super();
	}

	public BookReservationVo(int reserve_seq, String reserve_date, int reserve_period) {
		super();
		this.reserve_seq = reserve_seq;
		this.reserve_date = reserve_date;
		this.reserve_period = reserve_period;
	}

	public int getReserve_seq() {
		return reserve_seq;
	}

	public void setReserve_seq(int reserve_seq) {
		this.reserve_seq = reserve_seq;
	}

	public String getReserve_date() {
		return reserve_date;
	}

	public void setReserve_date(String reserve_date) {
		this.reserve_date = reserve_date;
	}

	public int getReserve_period() {
		return reserve_period;
	}

	public void setReserve_period(int reserve_period) {
		this.reserve_period = reserve_period;
	}

	@Override
	public String toString() {
		return "BookReservationVo [reserve_seq=" + reserve_seq + ", reserve_date=" + reserve_date + ", reserve_period="
				+ reserve_period + "]";
	}
	
}
