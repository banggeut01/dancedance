package com.dance.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dance.dto.Member;


@Repository
public class MemberDaoImpl {
	
	String ns = "dance.member.";
	@Autowired
	private SqlSession sqlSession;


	public Member login(Member login) {
		return sqlSession.selectOne(ns+"login", login);
	}
	
}
