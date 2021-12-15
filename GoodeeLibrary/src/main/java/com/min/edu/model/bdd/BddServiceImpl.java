package com.min.edu.model.bdd;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BddServiceImpl implements IBddService {

	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private IBddDao dao;
	
	@Override
	public int damagedBook(int seq) {
		log.info("BddServiceImpl 훼손 도서 신고");
		return dao.damagedBook(seq);
	}

}
