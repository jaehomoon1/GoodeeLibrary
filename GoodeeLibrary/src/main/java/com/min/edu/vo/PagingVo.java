	package com.min.edu.vo;
	
	import java.util.Date;
	
	import org.slf4j.Logger;
	import org.slf4j.LoggerFactory;
	
	public class PagingVo {
		
		Logger logger = LoggerFactory.getLogger(this.getClass());
		
		private int pageCnt; 		// 출력한 페이지 번호 개수
		private int index;			// 출력할 페이지 번호
		private int pageStartNum;	// 출력할 페이지 시작 번호
		private int listCnt;		// 출력한 리스트 개수
		private int total;			// 리스트의 총 개수
		
		{
			logger.info("============ PagingDto 초기화 블럭 실행 시간 {} ============", new Date());
			pageCnt = 7;
			index = 0;
			pageStartNum = 1;
			listCnt = 5;
		}
	
		public PagingVo() {
			
		}
	
		public PagingVo(int pageCnt, int index, int pageStartNum, int listCnt, int total) {
			super();
			this.pageCnt = pageCnt;
			this.index = index;
			this.pageStartNum = pageStartNum;
			this.listCnt = listCnt;
			this.total = total;
		}

		public PagingVo(String index, String pageStartNum, String listCnt) {
			logger.info("============ PagingDto 생성자 호출 실행 시간 {} ============", new Date());
			// view에서 전달 받은 parameter는 "" or null 객체로 판단하면
			// index의 초기값 0일 수 있음 하지만 parameter로 객체로 받을 경우 0과 값이 없음을 구분하기 편해짐
			if(index != null) {
				this.index = Integer.parseInt(index);
			}
			if(pageStartNum != null) {
				this.pageStartNum = Integer.parseInt(pageStartNum);
			}
			if(listCnt != null) {
				this.listCnt = Integer.parseInt(listCnt);
			}
		}
		
		public int getStart() {
			logger.info("============ PagingDto getStart 호출 실행 시간 {} ============", new Date());
			return index*listCnt +1;
		}
		
		public int getLast() {
			logger.info("============ PagingDto getLast 호출 실행 시간 {} ============", new Date());
			return (index*listCnt)+listCnt;
		}
		
		public int getPageLastNum() {
			logger.info("============ PagingDto getPageLastNum 호출 실행 시간 {} ============", new Date());

			int remainListCnt = total - listCnt *(pageStartNum-1);

			int remainPageCnt = remainListCnt/listCnt;

			if(remainPageCnt % listCnt != 0) {
				remainPageCnt++;
			}
			
			int pageLastNum = 0;
			if(remainListCnt <= listCnt) {
				pageLastNum = pageStartNum;
			}else if (remainPageCnt <= pageCnt) {
				pageLastNum = remainPageCnt + pageStartNum-1;
			}else {
				pageLastNum = pageCnt+pageStartNum-1;
			}
			return pageLastNum;
		}

		public Logger getLogger() {
			return logger;
		}

		public void setLogger(Logger logger) {
			this.logger = logger;
		}

		public int getPageCnt() {
			return pageCnt;
		}

		public void setPageCnt(int pageCnt) {
			this.pageCnt = pageCnt;
		}

		public int getIndex() {
			return index;
		}

		public void setIndex(int index) {
			this.index = index;
		}

		public int getPageStartNum() {
			return pageStartNum;
		}

		public void setPageStartNum(int pageStartNum) {
			this.pageStartNum = pageStartNum;
		}

		public int getListCnt() {
			return listCnt;
		}

		public void setListCnt(int listCnt) {
			this.listCnt = listCnt;
		}

		public int getTotal() {
			return total;
		}

		public void setTotal(int total) {
			this.total = total;
		}

		@Override
		public String toString() {
			return "PagingDto [pageCnt=" + pageCnt + ", index=" + index + ", pageStartNum="
					+ pageStartNum + ", listCnt=" + listCnt + ", total=" + total + "]";
		}
		
		
		
	}
