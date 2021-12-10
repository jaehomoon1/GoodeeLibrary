package com.min.edu.book;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"documents","meta"})
public class kakaoBook {
	
	@JsonProperty("documents")
	private List<Document> documents=null;
	@JsonProperty("meta")
	private Meta meta;
	
	@JsonProperty("documents")
	public List<Document> getDocuments() {
		return documents;
	}
	@JsonProperty("documents")
	public void setDocuments(List<Document> documents) {
		this.documents = documents;
	}
	@JsonProperty("meta")
	public Meta getMeta() {
		return meta;
	}
	@JsonProperty("meta")
	public void setMeta(Meta meta) {
		this.meta = meta;
	}
	
	
}
