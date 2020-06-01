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
	private String file;
	private int difficulty;
	private int length;
	private int point;
	
	
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


	public Video(int video_id, String thumbnail, String title, String file, int difficulty, int length, int point) {
		super();
		this.video_id = video_id;
		this.thumbnail = thumbnail;
		this.title = title;
		this.file = file;
		this.difficulty = difficulty;
		this.length = length;
		this.point = point;
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
		return "Video [video_id=" + video_id + ", thumbnail=" + thumbnail + ", title=" + title + ", file=" + file
				+ ", difficulty=" + difficulty + ", length=" + length + ", point=" + point + "]";
	}


}