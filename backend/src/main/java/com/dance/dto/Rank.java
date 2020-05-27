package com.dance.dto;

import java.io.Serializable;
import java.util.List;

public class Rank implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -9071308506135918450L;
	
	private Video video;
	private List<Ranking> rank;
	
	
	public Rank() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Rank(Video video, List<Ranking> rank) {
		super();
		this.video = video;
		this.rank = rank;
	}


	public Video getVideo() {
		return video;
	}


	public void setVideo(Video video) {
		this.video = video;
	}


	public List<Ranking> getRank() {
		return rank;
	}


	public void setRank(List<Ranking> rank) {
		this.rank = rank;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public String toString() {
		return "Rank [video=" + video + ", rank=" + rank + "]";
	}


}
