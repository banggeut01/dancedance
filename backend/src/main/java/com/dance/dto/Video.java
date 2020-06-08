package com.dance.dto;

import java.io.Serializable;

public class Video implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3988238963421465578L;
	
	private int video_id;
	private String thumbnail;
	private String title;
	private String singer;
	private String file;
	private int difficulty;
	private int length;
	private int myPoint;
	
	
	public Video() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Video(int video_id, String thumbnail, String title, String file, int difficulty, int length) {
		super();
		this.video_id = video_id;
		this.thumbnail = thumbnail;
		this.title = title;
		this.file = file;
		this.difficulty = difficulty;
		this.length = length;
	}


	public Video(int video_id, String thumbnail, String title, String singer, String file, int difficulty, int length) {
		super();
		this.video_id = video_id;
		this.thumbnail = thumbnail;
		this.title = title;
		this.singer = singer;
		this.file = file;
		this.difficulty = difficulty;
		this.length = length;
	}


	public Video(int video_id, String thumbnail, String title, String file, int difficulty, int length, int myPoint) {
		super();
		this.video_id = video_id;
		this.thumbnail = thumbnail;
		this.title = title;
		this.file = file;
		this.difficulty = difficulty;
		this.length = length;
		this.myPoint = myPoint;
	}


	public Video(String file, int length) {
		super();
		this.file = file;
		this.length = length;
	}


	public int getVideo_id() {
		return video_id;
	}


	public void setVideo_id(int video_id) {
		this.video_id = video_id;
	}


	public String getThumbnail() {
		return thumbnail;
	}


	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getSinger() {
		return singer;
	}


	public void setSinger(String singer) {
		this.singer = singer;
	}


	public String getFile() {
		return file;
	}


	public void setFile(String file) {
		this.file = file;
	}


	public int getDifficulty() {
		return difficulty;
	}


	public void setDifficulty(int difficulty) {
		this.difficulty = difficulty;
	}


	public int getLength() {
		return length;
	}


	public void setLength(int length) {
		this.length = length;
	}


	public int getMyPoint() {
		return myPoint;
	}


	public void setMyPoint(int myPoint) {
		this.myPoint = myPoint;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public String toString() {
		return "Video [video_id=" + video_id + ", thumbnail=" + thumbnail + ", title=" + title + ", file=" + file
				+ ", difficulty=" + difficulty + ", length=" + length + ", myPoint=" + myPoint + "]";
	}


}
