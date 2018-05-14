package com.javaex.vo;

public class CateVo {

	private int no;
	private int cateNo;
	private String id;
	private String cateName;
	private String description;
	private String regDate;
	
	public CateVo(int cateNo, String id, String cateName, String description, String regDate) {
		this.cateNo = cateNo;
		this.id = id;
		this.cateName = cateName;
		this.description = description;
		this.regDate = regDate;
	}

	public CateVo() {

	}

	public CateVo(int no, int cateNo, String id, String cateName, String description, String regDate) {
		this.no = no;
		this.cateNo = cateNo;
		this.id = id;
		this.cateName = cateName;
		this.description = description;
		this.regDate = regDate;
	}

	public CateVo(int no, int cateNo, String cateName, String description) {
		super();
		this.no = no;
		this.cateNo = cateNo;
		this.cateName = cateName;
		this.description = description;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getCateNo() {
		return cateNo;
	}

	public void setCateNo(int cateNo) {
		this.cateNo = cateNo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCateName() {
		return cateName;
	}

	public void setCateName(String cateName) {
		this.cateName = cateName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	@Override
	public String toString() {
		return "CateVo [no=" + no + ", cateNo=" + cateNo + ", id=" + id + ", cateName=" + cateName + ", description="
				+ description + ", regDate=" + regDate + "]";
	}
	
	
	
	
}
