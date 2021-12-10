package com.min.edu.book;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder(
	{
	"authors",
	"contents",
    "datetime",
    "isbn",
    "price",
    "publisher",
    "sale_price",
    "status",
    "thumbnail",
    "title",
    "translators",
    "url"
	}
	)
public class Document {
	
	@JsonProperty("authors")
	private List<String> authors = null;
	@JsonProperty("contents")
	private String contents;
	@JsonProperty("datetime")
	private String datetime;
	@JsonProperty("isbn")
	private String isbn;
	@JsonProperty("price")
	private Integer price;
	@JsonProperty("publisher")
	private String publisher;
	@JsonProperty("sale_price")
	private Integer sale_price;
	@JsonProperty("status")
	private String status;
	@JsonProperty("thumbnail")
	private String thumbnail;
	@JsonProperty("title")
	private String title;
	@JsonProperty("translators")
	private List<String> translators = null;
	@JsonProperty("url")
	private String url;
	
	@JsonProperty("authors")
	public List<String> getAuthors() {
		return authors;
	}
	@JsonProperty("authors")
	public void setAuthors(List<String> authors) {
		this.authors = authors;
	}
	@JsonProperty("contents")
	public String getContents() {
		return contents;
	}
	@JsonProperty("contents")
	public void setContents(String contents) {
		this.contents = contents;
	}
	@JsonProperty("datetime")
	public String getDatetime() {
		return datetime;
	}
	@JsonProperty("datetime")
	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}
	@JsonProperty("isbn")
	public String getIsbn() {
		return isbn;
	}
	@JsonProperty("isbn")
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	@JsonProperty("price")
	public Integer getPrice() {
		return price;
	}
	@JsonProperty("price")
	public void setPrice(Integer price) {
		this.price = price;
	}
	@JsonProperty("publisher")
	public String getPublisher() {
		return publisher;
	}
	@JsonProperty("publisher")
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	@JsonProperty("sale_price")
	public Integer getSale_price() {
		return sale_price;
	}
	@JsonProperty("sale_price")
	public void setSale_price(Integer sale_price) {
		this.sale_price = sale_price;
	}
	@JsonProperty("status")
	public String getStatus() {
		return status;
	}
	@JsonProperty("status")
	public void setStatus(String status) {
		this.status = status;
	}
	@JsonProperty("thumbnail")
	public String getThumbnail() {
		return thumbnail;
	}
	@JsonProperty("thumbnail")
	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}
	@JsonProperty("title")
	public String getTitle() {
		return title;
	}
	@JsonProperty("title")
	public void setTitle(String title) {
		this.title = title;
	}
	@JsonProperty("translators")
	public List<String> getTranslators() {
		return translators;
	}
	@JsonProperty("translators")
	public void setTranslators(List<String> translators) {
		this.translators = translators;
	}
	@JsonProperty("url")
	public String getUrl() {
		return url;
	}
	@JsonProperty("url")
	public void setUrl(String url) {
		this.url = url;
	}
	
	
	
	
                                
}
