package com.dance.dto;

import java.io.Serializable;

public class Ranking implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5454871173359105802L;
	
	private int ranking;
	private int member_id;
	private String nickname;
	private int avatar_now;
	private String img;
	private int point;
	
	
	public Ranking() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Ranking(int ranking, int member_id, String nickname, int avatar_now, String img, int point) {
		super();
		this.ranking = ranking;
		this.member_id = member_id;
		this.nickname = nickname;
		this.avatar_now = avatar_now;
		this.img = img;
		this.point = point;
	}


	public int getRanking() {
		return ranking;
	}


	public void setRanking(int ranking) {
		this.ranking = ranking;
	}


	public int getMember_id() {
		return member_id;
	}


	public void setMember_id(int member_id) {
		this.member_id = member_id;
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


	public String getImg() {
		return img;
	}


	public void setImg(String img) {
		this.img = img;
	}


	public int getPoint() {
		return point;
	}


	public void setPoint(int point) {
		this.point = point;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public String toString() {
		return "Ranking [ranking=" + ranking + ", member_id=" + member_id + ", nickname=" + nickname + ", avatar_now="
				+ avatar_now + ", img=" + img + ", point=" + point + "]";
	}


}
