package com.dance.service;

import java.util.List;

import com.dance.dto.Avatar;
import com.dance.dto.Member;

public interface IMemberService {

	Member login(Member login);

	int emailcheck(String email);

	void signup(Member member);

	Avatar myavatar(int member_id);

	List<Avatar> obtained(int member_id);

	List<Avatar> not_obtained(int member_id);

}
