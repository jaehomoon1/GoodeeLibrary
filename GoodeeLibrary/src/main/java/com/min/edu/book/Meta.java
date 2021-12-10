package com.min.edu.book;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/*
 * "meta": {
 * 			"is_end":false,
 * 			"pageable_count": 13,
 * 			"total_count":15
 * 			}
 * 	kakaoBook검색을 통해서 나오는 JSON의 Meta값의 결과를 매핑 및 담는 객체
 *  xml vs html 차이점 : well-formed, valid
 *  JSON도 XML의 Node-tree의 순서가 valid해야한다
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
	  			"is_end",
	  			"pageable_count",
	  			"total_count"
	  			}
)

public class Meta {
	
	@JsonProperty("is_end")
	private Boolean isEnd;
	@JsonProperty("pageable_count")
	private Integer pageableCount;
	@JsonProperty("total_count")
	private Integer totalCount;
	
	@JsonProperty("is_end")
	public Boolean getIsEnd() {
		return isEnd;
	}
	@JsonProperty("is_end")
	public void setIsEnd(Boolean isEnd) {
		this.isEnd = isEnd;
	}
	@JsonProperty("pageable_count")
	public Integer getPageableCount() {
		return pageableCount;
	}
	@JsonProperty("pageable_count")
	public void setPageableCount(Integer pageableCount) {
		this.pageableCount = pageableCount;
	}
	@JsonProperty("total_count")
	public Integer getTotalCount() {
		return totalCount;
	}
	@JsonProperty("total_count")
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}
	
	
	
	
}
