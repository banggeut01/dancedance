package com.dance.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dance.dto.Avatar;
import com.dance.dto.Member;


@Repository
public class MemberDaoImpl {
	
	String ns = "dance.member.";
	@Autowired
	private SqlSession sqlSession;


	public Member login(Member login) {
		return sqlSession.selectOne(ns+"login", login);
	}


	public int emailcheck(String email) {
		return sqlSession.selectOne(ns+"emailcheck", email);
	}
	
	
	public int nicknamecheck(String nickname) {
		return sqlSession.selectOne(ns+"nicknamecheck", nickname);
	}


	public void signup(Member member) {
		sqlSession.insert(ns+"signup", member);
	}


	public void updateMyAvatar(Member member) {
		sqlSession.update(ns+"updateMyAvatar", member);
	}


	public List<Avatar> getAvatarList() {
		return sqlSession.selectList(ns+"getAvatarList");
	}

	
}
