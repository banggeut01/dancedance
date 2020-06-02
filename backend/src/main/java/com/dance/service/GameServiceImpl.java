package com.dance.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dance.dao.GameDaoImpl;
import com.dance.dao.MemberDaoImpl;
import com.dance.dto.Avatar;
import com.dance.dto.Icon;
import com.dance.dto.Member;
import com.dance.dto.Play;
import com.dance.dto.Ranking;
import com.dance.dto.Video;


@Service
public class GameServiceImpl implements IGameService {
	
	@Autowired
	private GameDaoImpl gamedao;

	@Override
	@Transactional(readOnly=true)
	public List<Video> getVideoList() {
		return gamedao.getVideoList();
	}

	@Override
	@Transactional(readOnly=true)
	public int getVideoMyPoint(Play play) {
		return gamedao.getVideoMyPoint(play);
	}

	@Override
	@Transactional(readOnly=true)
	public String getVideoLink(int video_id) {
		return gamedao.getVideoLink(video_id);
	}

	@Override
	@Transactional(readOnly=true)
	public String getMyAvatarName(int avatar_now) {
		return gamedao.getMyAvatarName(avatar_now);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Icon> getIcon(int video_id) {
		return gamedao.getIcon(video_id);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Ranking> getRankingByVideo(int video_id) {
		return gamedao.getRankingByVideo(video_id);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Ranking> getRankingByScore() {
		return gamedao.getRankingByScore();
	}

	@Override
	@Transactional
	public void setPlayResult(Play play) {
		gamedao.setPlayResult(play);
	}

	@Override
	@Transactional(readOnly=true)
	public Play getPlayResult(int member_id) {
		return gamedao.getPlayResult(member_id);
	}

	@Override
	@Transactional(readOnly=true)
	public int getMyRanking(Play play) {
		return gamedao.getMyRanking(play);
	}

	@Override
	@Transactional(readOnly=true)
	public int getPerfectPoint(int video_id) {
		return gamedao.getPerfectPoint(video_id);
	}

	@Override
	@Transactional(readOnly=true)
	public String getMyAvatar(int avatar_id) {
		return gamedao.getMyAvatar(avatar_id);
	}

}
