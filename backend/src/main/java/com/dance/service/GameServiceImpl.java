package com.dance.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dance.dao.GameDaoImpl;
import com.dance.dao.MemberDaoImpl;
import com.dance.dto.Avatar;
import com.dance.dto.Member;
import com.dance.dto.Play;
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


}
