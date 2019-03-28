package com.leesungbok.dto;

import java.util.Date;

public class MusicListDto {
	private int listno;
	private String mustype;
	private String title;
	private String userid;
	private Date musdate;
	private int muscount;
	private String description;
	private String muspic1;
	private String muspic2;
	private String muspic3;
	private String muspic4;
	public int getListno() {
		return listno;
	}
	public void setListno(int listno) {
		this.listno = listno;
	}
	public String getMustype() {
		return mustype;
	}
	public void setMustype(String mustype) {
		this.mustype = mustype;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public Date getMusdate() {
		return musdate;
	}
	public void setMusdate(Date musdate) {
		this.musdate = musdate;
	}
	public int getMuscount() {
		return muscount;
	}
	public void setMuscount(int muscount) {
		this.muscount = muscount;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getMuspic1() {
		return muspic1;
	}
	public void setMuspic1(String muspic1) {
		this.muspic1 = muspic1;
	}
	public String getMuspic2() {
		return muspic2;
	}
	public void setMuspic2(String muspic2) {
		this.muspic2 = muspic2;
	}
	public String getMuspic3() {
		return muspic3;
	}
	public void setMuspic3(String muspic3) {
		this.muspic3 = muspic3;
	}
	public String getMuspic4() {
		return muspic4;
	}
	public void setMuspic4(String muspic4) {
		this.muspic4 = muspic4;
	}
}
