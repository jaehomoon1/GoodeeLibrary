package com.min.edu.vo;

public class BookVo {

	private int book_seq;
	private String thumbnail;
	private String title;
	private String authors;
	private String publisher;
	private String datetime;
	private String isbn;
	private String contents;
	private int price;
	private String delflag;
	
	@Override
	public String toString() {
		return "BookVo [book_seq=" + book_seq + ", thumbnail=" + thumbnail + ", title=" + title + ", authors=" + authors
				+ ", publisher=" + publisher + ", datetime=" + datetime + ", isbn=" + isbn + ", contents=" + contents
				+ ", price=" + price + ", delflag=" + delflag + "]";
	}
	
	public BookVo() {
		super();
	}


	public int getBook_seq() {
		return book_seq;
	}
	public void setBook_seq(int book_seq) {
		this.book_seq = book_seq;
	}
	public String getThumbnail() {
		return thumbnail;
	}
	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthors() {
		return authors;
	}
	public void setAuthors(String authors) {
		this.authors = authors;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getDatetime() {
		return datetime;
	}
	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getDelflag() {
		return delflag;
	}
	public void setDelflag(String delflag) {
		this.delflag = delflag;
	}

	public BookVo(String thumbnail, String title, String authors, String publisher, String datetime, String isbn,
			String contents, int price) {
		super();
		this.thumbnail = thumbnail;
		this.title = title;
		this.authors = authors;
		this.publisher = publisher;
		this.datetime = datetime;
		this.isbn = isbn;
		this.contents = contents;
		this.price = price;
	}

	public BookVo(int book_seq, String thumbnail, String title, String authors, String publisher, String datetime,
			String isbn, String contents, int price, String delflag) {
		super();
		this.book_seq = book_seq;
		this.thumbnail = thumbnail;
		this.title = title;
		this.authors = authors;
		this.publisher = publisher;
		this.datetime = datetime;
		this.isbn = isbn;
		this.contents = contents;
		this.price = price;
		this.delflag = delflag;
	}
	
	

	
	
}
