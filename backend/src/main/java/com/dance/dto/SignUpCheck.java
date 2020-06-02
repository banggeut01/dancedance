package com.dance.dto;

import java.io.Serializable;

public class SignUpCheck implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2850807531444563451L;
	
	private String email;
	private String nickname;
	
	
	public SignUpCheck() {
		super();
		// TODO Auto-generated constructor stub
	}


	public SignUpCheck(String email, String nickname) {
		super();
		this.email = email;
		this.nickname = nickname;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getNickname() {
		return nickname;
	}


	public void setNickname(String nickname) {
		this.nickname = nickname;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public String toString() {
		return "SignUpCheck [email=" + email + ", nickname=" + nickname + "]";
	}
	

}
