package com.bean;
/*
 * 借书类：
 * 借书的书编号
 * 借书卡编号
 * 借书时间
 * 借书数目
 */
public class Borrowed_book {
	private String book_no;
	private String Scard_no;
	private String borrowed_book_time;
	private String borrowed_book_num;
	
	public Borrowed_book() {

	}

	public String getBook_no() {
		return book_no;
	}

	public void setBook_no(String book_no) {
		this.book_no = book_no;
	}

	public String getScard_no() {
		return Scard_no;
	}

	public void setScard_no(String scard_no) {
		Scard_no = scard_no;
	}

	public String getBorrowed_book_time() {
		return borrowed_book_time;
	}

	public void setBorrowed_book_time(String borrowed_book_time) {
		this.borrowed_book_time = borrowed_book_time;
	}

	public String getBorrowed_book_num() {
		return borrowed_book_num;
	}

	public void setBorrowed_book_num(String borrowed_book_num) {
		this.borrowed_book_num = borrowed_book_num;
	}

}
