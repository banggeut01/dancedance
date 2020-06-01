package com.dance.dto;

import java.io.Serializable;

public class Icon implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8469585024456611158L;
	
	private int video_id;
	private int icon_id;
	private String img;
	private int sec;
	private int excellent;
	private int great;
	private int good;
	private int bad;
	
	
	public Icon() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Icon(int icon_id, String img, int sec, int excellent, int great, int good, int bad) {
		super();
		this.icon_id = icon_id;
		this.img = img;
		this.sec = sec;
		this.excellent = excellent;
		this.great = great;
		this.good = good;
		this.bad = bad;
	}


	public Icon(int icon_id, String img, int sec) {
		super();
		this.icon_id = icon_id;
		this.img = img;
		this.sec = sec;
	}


	public Icon(int video_id, int icon_id, String img) {
		super();
		this.video_id = video_id;
		this.icon_id = icon_id;
		this.img = img;
	}


	public int getVideo_id() {
		return video_id;
	}


	public void setVideo_id(int video_id) {
		this.video_id = video_id;
	}


	public int getIcon_id() {
		return icon_id;
	}


	public void setIcon_id(int icon_id) {
		this.icon_id = icon_id;
	}


	public String getImg() {
		return img;
	}


	public void setImg(String img) {
		this.img = img;
	}


	public int getSec() {
		return sec;
	}


	public void setSec(int sec) {
		this.sec = sec;
	}


	public int getExcellent() {
		return excellent;
	}


	public void setExcellent(int excellent) {
		this.excellent = excellent;
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
		return "Icon [video_id=" + video_id + ", icon_id=" + icon_id + ", img=" + img + ", sec=" + sec + ", excellent="
				+ excellent + ", great=" + great + ", good=" + good + ", bad=" + bad + "]";
	}


}
