package com.dance.dto;

import java.io.Serializable;

public class Result implements Serializable {
		
	/**
	 * 
	 */
	private static final long serialVersionUID = 558913581199367162L;
	
	private int video_id;
	private int perfect;
	private int great;
	private int good;
	private int bad;
	
	
	public Result() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Result(int video_id, int perfect, int great, int good, int bad) {
		super();
		this.video_id = video_id;
		this.perfect = perfect;
		this.great = great;
		this.good = good;
		this.bad = bad;
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


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public String toString() {
		return "Result [video_id=" + video_id + ", perfect=" + perfect + ", great=" + great + ", good=" + good
				+ ", bad=" + bad + "]";
	}


}
