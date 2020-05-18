package com.dance.dto;

import java.io.Serializable;

public class Member implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2765211379377001811L;
	
	private int member_id;
	private String email;
	private String password;
	private String nickname;
	private int avatar_now;
	
	
	public Member() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Member(int member_id, String email, String password, String nickname, int avatar_now) {
		super();
		this.member_id = member_id;
		this.email = email;
		this.password = password;
		this.nickname = nickname;
		this.avatar_now = avatar_now;
	}


	public Member(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}


	public Member(String email, String password, String nickname) {
		super();
		this.email = email;
		this.password = password;
		this.nickname = nickname;
	}


	public int getMember_id() {
		return member_id;
	}


	public void setMember_id(int member_id) {
		this.member_id = member_id;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getNickname() {
		return nickname;
	}


	public void setNickname(String nickname) {
		this.nickname = nickname;
	}


	public int getAvatar_now() {
		return avatar_now;
	}


	public void setAvatar_now(int avatar_now) {
		this.avatar_now = avatar_now;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public String toString() {
		return "Member [member_id=" + member_id + ", email=" + email + ", password=" + password + ", nickname="
				+ nickname + ", avatar_now=" + avatar_now + "]";
	}

	

}
