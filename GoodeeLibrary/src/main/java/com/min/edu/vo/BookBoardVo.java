package com.min.edu.vo;

public class BookBoardVo {

	private int board_seq;
	private String board_type;
	private String id;
	private String title;
	private String content;
	private String delflag;
	private String regdate;
	
	public int getBoard_seq() {
		return board_seq;
	}
	public void setBoard_seq(int board_seq) {
		this.board_seq = board_seq;
	}
	public String getBoard_type() {
		return board_type;
	}
	public void setBoard_type(String board_type) {
		this.board_type = board_type;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getDelflag() {
		return delflag;
	}
	public void setDelflag(String delflag) {
		this.delflag = delflag;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	
	@Override
	public String toString() {
		return "BookBoardVo [board_seq=" + board_seq + ", board_type=" + board_type + ", id=" + id + ", title=" + title
				+ ", content=" + content + ", delflag=" + delflag + ", regdate=" + regdate + "]";
	}
	
	public BookBoardVo() {
		super();
	}
	
	
	
}
