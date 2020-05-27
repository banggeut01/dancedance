package com.dance.dto;

import java.io.Serializable;

public class Ranking implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5454871173359105802L;
	
	private int ranking;
	private int member_id;
	private int point;
	
	
	public Ranking() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Ranking(int ranking, int member_id, int point) {
		super();
		this.ranking = ranking;
		this.member_id = member_id;
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
		return "Ranking [ranking=" + ranking + ", member_id=" + member_id + ", point=" + point + "]";
	}


}
