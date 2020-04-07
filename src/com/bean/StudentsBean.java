package com.bean;

/*
 * 学生信息：
 * 借书卡编号
 * 密码
 * 姓名
 * 性别
 * 年级
 * 登陆状态
 */
public class StudentsBean {

	private String Scard_no;
	private String Spwd;
	private String Sname;
	private String Ssex;
	private String grade;
	private boolean logined = false;  
	
	public  StudentsBean() {
		
	}

	public String getScard_no() {
		return Scard_no;
	}

	public void setScard_no(String scard_no) {
		Scard_no = scard_no;
	}

	public String getSpwd() {
		return Spwd;
	}

	public void setSpwd(String spwd) {
		Spwd = spwd;
	}

	public String getSname() {
		return Sname;
	}

	public void setSname(String sname) {
		Sname = sname;
	}

	public String getSsex() {
		return Ssex;
	}

	public void setSsex(String ssex) {
		Ssex = ssex;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public boolean isLogined() {
		return logined;
	}

	public void setLogined(boolean logined) {
		this.logined = logined;
	}
	
	
	
}
