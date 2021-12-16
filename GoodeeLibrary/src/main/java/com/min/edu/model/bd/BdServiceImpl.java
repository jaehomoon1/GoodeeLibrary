package com.min.edu.model.bd;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BdServiceImpl implements IBdService {

	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private IBdDao dao;
	
	@Override
	public int damagedBook(int seq) {
		log.info("BdServiceImpl 훼손 도서 신고");
		return dao.damagedBook(seq);
	}

}
