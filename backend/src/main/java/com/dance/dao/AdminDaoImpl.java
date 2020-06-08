package com.dance.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dance.dto.Avatar;
import com.dance.dto.Icon;
import com.dance.dto.Member;
import com.dance.dto.Play;
import com.dance.dto.Ranking;
import com.dance.dto.Video;


@Repository
public class AdminDaoImpl {
	
	String ns = "dance.admin.";
	
	@Autowired
	private SqlSession sqlSession;

	public void setIcon(List<Icon> icon) {
		sqlSession.insert(ns+"setIcon", icon);
	}

}
