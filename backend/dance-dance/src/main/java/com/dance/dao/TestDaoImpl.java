package com.dance.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dance.dto.Test;

@Repository
public class TestDaoImpl {
	
	String ns = "dance.test.";
	@Autowired
	private SqlSession sqlSession;


	public Test test() {
		return sqlSession.selectOne(ns+"test");
	}
	
}
