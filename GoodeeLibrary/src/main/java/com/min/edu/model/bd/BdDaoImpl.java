package com.min.edu.model.bd;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BdDaoImpl implements IBdDao {

	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public int damagedBook(int damage_seq) {
		return sqlSession.update("com.min.edu.model.bd.BdDaoImpl.damagedBook", damage_seq);
	}

}
