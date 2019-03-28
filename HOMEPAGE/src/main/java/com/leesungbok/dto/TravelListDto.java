package com.leesungbok.dto;

import java.util.Date;

public class TravelListDto {
	private int listno;
	private String tratype;
	private String title;
	private String userid;
	private Date tradate;
	private int tracount;
	private String description;
	private String trapic1;
	private String trapic2;
	private String trapic3;
	private String trapic4;
	public int getListno() {
		return listno;
	}
	public void setListno(int listno) {
		this.listno = listno;
	}
	public String getTratype() {
		return tratype;
	}
	public void setTratype(String tratype) {
		this.tratype = tratype;
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
	public Date getTradate() {
		return tradate;
	}
	public void setTradate(Date tradate) {
		this.tradate = tradate;
	}
	public int getTracount() {
		return tracount;
	}
	public void setTracount(int tracount) {
		this.tracount = tracount;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getTrapic1() {
		return trapic1;
	}
	public void setTrapic1(String trapic1) {
		this.trapic1 = trapic1;
	}
	public String getTrapic2() {
		return trapic2;
	}
	public void setTrapic2(String trapic2) {
		this.trapic2 = trapic2;
	}
	public String getTrapic3() {
		return trapic3;
	}
	public void setTrapic3(String trapic3) {
		this.trapic3 = trapic3;
	}
	public String getTrapic4() {
		return trapic4;
	}
	public void setTrapic4(String trapic4) {
		this.trapic4 = trapic4;
	}
}
