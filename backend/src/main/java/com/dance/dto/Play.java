package com.dance.dto;

import java.io.Serializable;

public class Play implements Serializable {
		
	/**
	 * 
	 */
	private static final long serialVersionUID = 558913581199367162L;
	
	private int play_id;
	private int member_id;
	private int video_id;
	private int perfect;
	private int great;
	private int good;
	private int bad;
	private int point;
	private String datetime;
	
	
	public Play() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Play(int play_id, int member_id, int video_id, int perfect, int great, int good, int bad, int point,
			String datetime) {
		super();
		this.play_id = play_id;
		this.member_id = member_id;
		this.video_id = video_id;
		this.perfect = perfect;
		this.great = great;
		this.good = good;
		this.bad = bad;
		this.point = point;
		this.datetime = datetime;
	}


	public Play(int member_id, int video_id, int perfect, int great, int good, int bad, int point) {
		super();
		this.member_id = member_id;
		this.video_id = video_id;
		this.perfect = perfect;
		this.great = great;
		this.good = good;
		this.bad = bad;
		this.point = point;
	}


	public Play(int video_id, int perfect, int great, int good, int bad) {
		super();
		this.video_id = video_id;
		this.perfect = perfect;
		this.great = great;
		this.good = good;
		this.bad = bad;
	}


	public Play(int play_id, int video_id, int point, String datetime) {
		super();
		this.play_id = play_id;
		this.video_id = video_id;
		this.point = point;
		this.datetime = datetime;
	}


	public Play(int member_id, int video_id) {
		super();
		this.member_id = member_id;
		this.video_id = video_id;
	}


	public int getPlay_id() {
		return play_id;
	}


	public void setPlay_id(int play_id) {
		this.play_id = play_id;
	}


	public int getMember_id() {
		return member_id;
	}


	public void setMember_id(int member_id) {
		this.member_id = member_id;
	}


	public int getVideo_id() {
		return video_id;
	}


	public void setVideo_id(int video_id) {
		this.video_id = video_id;
	}


	public int getPerfect() {
		return perfect;
	}


	public void setPerfect(int perfect) {
		this.perfect = perfect;
	}


	public int getGreat() {
		return great;
	}


	public void setGreat(int great) {
		this.great = great;
	}


	public int getGood() {
		return good;
	}


	public void setGood(int good) {
		this.good = good;
	}


	public int getBad() {
		return bad;
	}


	public void setBad(int bad) {
		this.bad = bad;
	}


	public int getPoint() {
		return point;
	}


	public void setPoint(int point) {
		this.point = point;
	}


	public String getDatetime() {
		return datetime;
	}


	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public String toString() {
		return "Play [play_id=" + play_id + ", member_id=" + member_id + ", video_id=" + video_id + ", perfect="
				+ perfect + ", great=" + great + ", good=" + good + ", bad=" + bad + ", point=" + point
				+ ", datetime=" + datetime + "]";
	}


}
