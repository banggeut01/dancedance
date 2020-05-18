package com.dance.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.dance.dto.Member;


public interface IJwtService {

	boolean isUsable(String jwt);

//	String signin(Member data);

	Member get(HttpServletRequest req);

	String create(Member data);

}
