package com.min.edu.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.min.edu.book.kakaoBook;
import com.min.edu.model.book.IBookService;
import com.min.edu.vo.BookVo;

@Controller
public class APIController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private IBookService service;
	
	public static String kakao_book_rest_uri ="https://dapi.kakao.com/v3/search/book?target=title";
	public static String kakao_rest_api_appkey = "07535f2f0d93aa2cb98883e2dbaeda11"; //본인거추가

	@GetMapping(value = "/kakao_book.do")
	public String kakaoBook(Model model, @RequestParam(required = false) String searchWord, HttpSession session) {
		logger.info("카카오 검색(북) {}", searchWord);
		
		RestTemplate restTemplate = new RestTemplate();
		kakaoBook kakaoBook = null;
		
		if(searchWord == "") {
			return "book/searchBook";
		}
		
		
		if(searchWord == null) {
			searchWord = (String) session.getAttribute("Word");
			MultiValueMap<String, String> header = new LinkedMultiValueMap<String, String>();
			header.add("Authorization", "KakaoAK "+kakao_rest_api_appkey);
			
			//Response객체를 보내줘야함
			// 처리방식 GET , URL , header , 받는 객체 kakaobook
			ResponseEntity<kakaoBook> kakaoBookResponseEntitiy =  
					restTemplate.exchange(
							kakao_book_rest_uri + "&query="+searchWord,
							HttpMethod.GET,
							new HttpEntity<>(header),
							kakaoBook.class
							);
		
			kakaoBook = kakaoBookResponseEntitiy.getBody(); //jackson property에 담아줌
		
			logger.info("카카오 북에 요청된 결과 값 \n {}",kakaoBook);
			model.addAttribute("searchWord", searchWord);
			model.addAttribute("book_name", searchWord);
			model.addAttribute("kakaoBook",kakaoBook);
			session.setAttribute("Word", searchWord);
			return "book/searchBook";
		}
		
		//kakao 전송을 위한 헤더정보인 Authorization KakaoAK {appkey}를 요청 할때 보내
		MultiValueMap<String, String> header = new LinkedMultiValueMap<String, String>();
		header.add("Authorization", "KakaoAK "+kakao_rest_api_appkey);
		
		//Response객체를 보내줘야함
		// 처리방식 GET , URL , header , 받는 객체 kakaobook
		ResponseEntity<kakaoBook> kakaoBookResponseEntitiy =  
				restTemplate.exchange(
						kakao_book_rest_uri + "&query="+searchWord,
						HttpMethod.GET,
						new HttpEntity<>(header),
						kakaoBook.class
						);
	
		kakaoBook = kakaoBookResponseEntitiy.getBody(); //jackson property에 담아줌
	
		logger.info("카카오 북에 요청된 결과 값 \n {}",kakaoBook);
		model.addAttribute("searchWord", searchWord);
		model.addAttribute("book_name", searchWord);
		model.addAttribute("kakaoBook",kakaoBook);
		session.setAttribute("Word", searchWord);
		return "book/searchBook";
	}
	
	@GetMapping(value = "/search_book.do")
	public String searchbook() {
		
		return "book/searchBook";
	}
	
	@PostMapping(value = "/bookdetail.do")
	public String bookdetail(String thumbnail ,String title ,String contents,
			String datetime, String isbn, String price,
			String publisher, String authors ,Model model) {

		
		model.addAttribute("authors",authors);
		model.addAttribute("publisher",publisher);
		model.addAttribute("datetime",datetime);
		model.addAttribute("isbn",isbn);
		model.addAttribute("price",price);
		model.addAttribute("contents",contents);
		model.addAttribute("thumbnail",thumbnail);
		model.addAttribute("title",title);
		
		return "book/bookDetail";
	}
	
	
	@PostMapping(value = "/insertBook.do")
	public String insertbook(String thumbnail ,String title ,String contents,
			String datetime, String isbn, String price,
			String publisher, String authors , int book_count) {

		if(thumbnail == "") {
			thumbnail = " ";
		}
		if(title == "") {
			title = " ";
		}
		if(contents == "") {
			contents = " ";
		}
		if(datetime == "") {
			datetime = " ";
		}
		if(isbn == "") {
			isbn = " ";
		}
		if(price == "") {
			price = " ";
		}
		if(publisher == "") {
			publisher = " ";
		}
		if(authors == "") {
			authors = " ";
		}
		
		
		datetime = datetime.substring(0,10);
		BookVo vo = new BookVo(thumbnail,  title,  authors,  publisher,  datetime,  isbn,
				 contents, Integer.parseInt(price));
		System.out.println(vo.toString());
		for (int i = 0; i < book_count; i++) {
			service.insertBook(vo);		
		}
	
		
		return "redirect:/kakao_book.do";
		
	}
	
}
