package com.dance.dto;

import java.io.Serializable;

public class Avatar implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -9071308506135918450L;
	
	private int avatar_id;
	private String name;
	private String img;
	private String url;
	private boolean selected;
	
	
	public Avatar() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Avatar(int avatar_id, String name, String img, String url, boolean selected) {
		super();
		this.avatar_id = avatar_id;
		this.name = name;
		this.img = img;
		this.url = url;
		this.selected = selected;
	}


	public Avatar(int avatar_id, String name, String img) {
		super();
		this.avatar_id = avatar_id;
		this.name = name;
		this.img = img;
	}


	public Avatar(int avatar_id, String name, String img, String url) {
		super();
		this.avatar_id = avatar_id;
		this.name = name;
		this.img = img;
		this.url = url;
	}


	public int getAvatar_id() {
		return avatar_id;
	}


	public void setAvatar_id(int avatar_id) {
		this.avatar_id = avatar_id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getImg() {
		return img;
	}


	public void setImg(String img) {
		this.img = img;
	}


	public String getUrl() {
		return url;
	}


	public void setUrl(String url) {
		this.url = url;
	}


	public boolean isSelected() {
		return selected;
	}


	public void setSelected(boolean selected) {
		this.selected = selected;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public String toString() {
		return "Avatar [avatar_id=" + avatar_id + ", name=" + name + ", img=" + img + ", url=" + url + ", selected="
				+ selected + "]";
	}


}
