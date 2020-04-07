package com.bean;
/*
 * 还书类：
 * 书编号
 * 借书卡编号
 * 还书时间
 * 还书数目
 */
public class Return_book {
	private String book_no;
	private String Scard_no;
	private String return_book_time;
	private String return_book_num;
	
	public String getReturn_book_num() {
		return return_book_num;
	}

	public void setReturn_book_num(String return_book_num) {
		this.return_book_num = return_book_num;
	}

	public Return_book() {

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

	public String getReturn_book_time() {
		return return_book_time;
	}

	public void setReturn_book_time(String return_book_time) {
		this.return_book_time = return_book_time;
	}


}
