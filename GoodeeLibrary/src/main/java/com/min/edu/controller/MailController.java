package com.min.edu.controller;

import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MailController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private JavaMailSender mailSender;
	
	@GetMapping(value="/mailform.do")
	public String mailForm() {
		logger.info("MailController 메일 작성 화면");
		return "report/mailForm";
	}
	
	@PostMapping(value="/mailSender.do")
	public String mailSender(@RequestParam Map<String, String> map) {
		logger.info("MailController 메일 보내기 값 {}", map);
		
		//발신자 메일주소 > 필수값
		String setFrom = "g00glelib@gmail.com";
		
		//메일 전송 객체 MimeMessage
		MimeMessage message = mailSender.createMimeMessage();
		
		//MimeMessage는 파일첨부 t/f, text/html, Encoding
		try {
			
			MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8");
			
			messageHelper.setFrom(setFrom); // 발신자 메일주소 
			messageHelper.setTo(map.get("tomail")); // 수신자 메일주소
			messageHelper.setSubject(map.get("title")); // 메일 제목, 생략가능
			messageHelper.setText(map.get("content"), false); // 글자의 형태, true면 html로 인식
			
			mailSender.send(message);
			
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		return "redirect:/mailform.do";
	}
	
}
