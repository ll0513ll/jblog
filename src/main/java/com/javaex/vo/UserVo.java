package com.javaex.vo;

public class UserVo {

	private int no;
	private String id;
	private String userName;
	private String password;
	private String joinDate;
	
	public UserVo(int no, String id, String userName, String password, String joinDate) {
		this.no = no;
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.joinDate = joinDate;
	}

	public UserVo() {
	
	}

	public UserVo(String id, String userName, String password) {
		this.id = id;
		this.userName = userName;
		this.password = password;
	}

	public UserVo(int no, String id, String userName, String password) {
		this.no = no;
		this.id = id;
		this.userName = userName;
		this.password = password;
	}

	public UserVo(String id, String userName, String password, String joinDate) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.joinDate = joinDate;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(String joinDate) {
		this.joinDate = joinDate;
	}

	@Override
	public String toString() {
		return "UserVo [no=" + no + ", id=" + id + ", name=" + userName + ", password=" + password + ", joinDate="
				+ joinDate + "]";
	}
	
	
	
}
