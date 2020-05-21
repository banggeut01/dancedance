package com.dance.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dance.dto.Avatar;
import com.dance.dto.Member;
import com.dance.dto.Play;
import com.dance.dto.Video;


@Repository
public class GameDaoImpl {
	
	String ns = "dance.game.";
	
	@Autowired
	private SqlSession sqlSession;
	
	public List<Video> getVideoList() {
		return sqlSession.selectList(ns+"getVideoList");
	}

	public int getVideoMyPoint(Play play) {
		try {
			return sqlSession.selectOne(ns+"getVideoMyPoint", play);
		}catch(Exception e) {
			return 0;
		}
	}

	
}
