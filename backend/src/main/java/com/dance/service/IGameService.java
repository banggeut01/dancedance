package com.dance.service;

import java.util.List;

import com.dance.dto.Play;
import com.dance.dto.Video;


public interface IGameService {

	List<Video> getVideoList();

	int getVideoMyPoint(Play play);

	

}
