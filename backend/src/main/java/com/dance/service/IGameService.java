package com.dance.service;

import java.util.List;

import com.dance.dto.Avatar;
import com.dance.dto.Icon;
import com.dance.dto.Play;
import com.dance.dto.Ranking;
import com.dance.dto.Video;


public interface IGameService {

	List<Video> getVideoList();

	int getVideoMyPoint(Play play);

	Video getVideo(int video_id);

	String getMyAvatarName(int avatar_now);

	List<Icon> getIcon(int video_id);

	List<Ranking> getRankingByVideo(int video_id);

	List<Ranking> getRankingByScore();

	void setPlayResult(Play play);

	Play getPlayResult(int member_id);

	int getMyRanking(Play play);

	int getPerfectPoint(int video_id);

	String getMyAvatar(int avatar_id);

}
