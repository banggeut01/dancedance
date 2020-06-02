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

	public String getVideoLink(int video_id) {
		return sqlSession.selectOne(ns+"getVideoLink", video_id);
	}

	public String getMyAvatarName(int avatar_now) {
		return sqlSession.selectOne(ns+"getMyAvatarName", avatar_now);
	}

	public List<Icon> getIcon(int video_id) {
		return sqlSession.selectList(ns+"getIcon", video_id);
	}

	public List<Ranking> getRankingByVideo(int video_id) {
		return sqlSession.selectList(ns+"getRankingByVideo", video_id);
	}

	public List<Ranking> getRankingByScore() {
		return sqlSession.selectList(ns+"getRankingByScore");
	}

	public void setPlayResult(Play play) {
		sqlSession.insert(ns+"setPlayResult", play);
	}

	public Play getPlayResult(int member_id) {
		return sqlSession.selectOne(ns+"getPlayResult", member_id);
	}

	public int getMyRanking(Play play) {
		return sqlSession.selectOne(ns+"getMyRanking", play);
	}

	public int getPerfectPoint(int video_id) {
		return sqlSession.selectOne(ns+"getPerfectPoint", video_id);
	}

	public String getMyAvatar(int avatar_id) {
		return sqlSession.selectOne(ns+"getMyAvatar", avatar_id);
	}

}
