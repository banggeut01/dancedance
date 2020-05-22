package com.dance.service;

import java.util.List;

import com.dance.dto.Avatar;
import com.dance.dto.Icon;
import com.dance.dto.Play;
import com.dance.dto.Video;


public interface IGameService {

	List<Video> getVideoList();

	int getVideoMyPoint(Play play);

	String getVideoLink(int video_id);

	String getMyAvatarName(int member_id);

	List<Icon> getIcon(int video_id);


}
