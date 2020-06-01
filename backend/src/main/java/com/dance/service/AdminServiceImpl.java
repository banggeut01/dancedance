package com.dance.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dance.dao.AdminDaoImpl;
import com.dance.dao.GameDaoImpl;
import com.dance.dao.MemberDaoImpl;
import com.dance.dto.Avatar;
import com.dance.dto.Icon;
import com.dance.dto.Member;
import com.dance.dto.Play;
import com.dance.dto.Ranking;
import com.dance.dto.Video;


@Service
public class AdminServiceImpl implements IAdminService {
	
	@Autowired
	private AdminDaoImpl admindao;

	@Override
	@Transactional
	public void setIcon(List<Icon> icon) {
		admindao.setIcon(icon);
	}

}
