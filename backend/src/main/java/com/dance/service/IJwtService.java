package com.dance.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.dance.dto.Member;


public interface IJwtService {

	boolean isUsable(String jwt);

//	String signin(Member data);

	Member get(String jwt);

	String create(Member data);

}
