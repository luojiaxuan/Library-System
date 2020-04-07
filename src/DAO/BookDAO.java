package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bean.Book_type;
import com.bean.Borrowed_book;
import com.bean.Return_book;
import com.bean.booksBean;
import com.db.DBUtil;
/*
 * BookDAO类
 * 将Book数据表与Book类联系起来
 */
public class BookDAO {

	//获得所有的书籍
	public ArrayList<booksBean> getAllBooksItem(){
		ArrayList<booksBean> list = new ArrayList<booksBean>();
		
		DBUtil db = new DBUtil();
		String sql = "select * from Book";
		ResultSet rs = db.query(sql);
		try {
			//一次拿一行
			while (rs.next()) {
				booksBean book = new booksBean();
				book.setBook_name(rs.getString("book_name"));
				book.setPicture(rs.getString("picture"));
				book.setBook_no(rs.getString("book_no"));
//				book.setBook_author(rs.getString("book_author"));
//				book.setBook_press(rs.getString("book_press"));
//				book.setBook_rest_num(rs.getInt("book_rest_num"));
//				book.setBook_type_no(rs.getString("book_type_no"));
//				book.setBook_details(rs.getString("book_details"));
				list.add(book);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		return null;
	}
	
	//通过Book_no获得书的实例
	public booksBean getBookByno(String Book_no){
		DBUtil db = new DBUtil();
		String sql = "select * from Book where book_no like '%"+Book_no+"%'";
		ResultSet rs = db.query(sql);
			try {
				if (rs.next()) {
					booksBean book = new booksBean();
					book.setBook_name(rs.getString("book_name"));
					book.setPicture(rs.getString("picture"));
					book.setBook_no(rs.getString("book_no"));
					book.setBook_author(rs.getString("book_author"));
					book.setBook_press(rs.getString("book_press"));
					book.setBook_rest_num(rs.getInt("book_rest_num"));
					book.setBook_type_no(rs.getString("book_type_no"));
					book.setBook_details(rs.getString("book_details"));
					return book;				
				}
				else{
					return null;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}return null;
	}
	//通过书籍类型编号获得书记类型
	public Book_type getBookTypeByno(String book_type_no){
		DBUtil dbUtil = new DBUtil();
		String sql = "select * from Book_type where book_type_no like '%"+book_type_no+"%'";
		ResultSet rs= dbUtil.query(sql);
		try {
			if(rs.next()){
				Book_type book_type=new Book_type();
				book_type.setBook_type_name(rs.getString("book_type_name"));
				return book_type;
			}
			else{
				return null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		return null;
	}
	//根据书籍作者获得相应的书籍列表
	public ArrayList<booksBean> getBooksByAuthor(String book_author){
		ArrayList<booksBean> list = new ArrayList<booksBean>();
		
		DBUtil db = new DBUtil();
		String sql = "select * from Book where book_author like '%"+book_author+"%'";
		ResultSet rs = db.query(sql);
		try {
			while (rs.next()) {
				booksBean book = new booksBean();
				book.setBook_name(rs.getString("book_name"));
				book.setBook_no(rs.getString("book_no"));
				book.setBook_author(rs.getString("book_author"));
				book.setBook_press(rs.getString("book_press"));
				book.setBook_rest_num(rs.getInt("book_rest_num"));
				book.setBook_type_no(rs.getString("book_type_no"));
				list.add(book);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		return null;
	}
	//根据出版社获得相应的书籍列表
	public ArrayList<booksBean> getBooksByPress(String book_press){
		ArrayList<booksBean> list = new ArrayList<booksBean>();
		DBUtil db = new DBUtil();
		String sql = "select * from Book where book_press like '%"+book_press+"%'";
		ResultSet rs = db.query(sql);
		try {
			while (rs.next()) {
				booksBean book = new booksBean();
				book.setBook_name(rs.getString("book_name"));
				book.setBook_no(rs.getString("book_no"));
				book.setBook_author(rs.getString("book_author"));
				book.setBook_press(rs.getString("book_press"));
				book.setBook_rest_num(rs.getInt("book_rest_num"));
				book.setBook_type_no(rs.getString("book_type_no"));
				list.add(book);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		return null;
	}

	//根据书籍名称获得相应的书籍类型编号
	public Book_type getBookTypenoByBookType(String book_type_name){
		DBUtil db=new DBUtil();
		String sql="select * from Book_type where book_type_name like '%"+book_type_name+"%'";
		ResultSet rs=db.query(sql);
		try {
			while(rs.next()){
				Book_type book_type=new Book_type();
				book_type.setBook_type_no(rs.getString("book_type_no"));
				book_type.setBook_type_name(book_type_name);
				return book_type;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		return null;
	}
	//根据书籍类型编号获得相应的书籍列表
	public ArrayList<booksBean>	getBookByBookTypeno(String book_type_no){
		ArrayList<booksBean> list=new ArrayList<booksBean>();
		DBUtil db=new DBUtil();
		String sql="select * from Book where book_type_no like '%"+book_type_no+"%'";
		ResultSet rs=db.query(sql);
			try {
				while(rs.next()){
					booksBean book= new booksBean();
					book.setBook_name(rs.getString("book_name"));
					book.setBook_no(rs.getString("book_no"));
					book.setBook_author(rs.getString("book_author"));
					book.setBook_press(rs.getString("book_press"));
					book.setBook_rest_num(rs.getInt("book_rest_num"));
					book.setBook_type_no(rs.getString("book_type_no"));
					list.add(book);
				}
				return list;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
		return null;
	}
	//根据书名获得相应的书籍
	public booksBean getBookByname(String Book_name){
		DBUtil db = new DBUtil();
		String sql = "select * from Book where book_name like '%"+Book_name+"%'";
		ResultSet rs = db.query(sql);
			try {
				if(rs.next()) {
					booksBean book= new booksBean();
					book.setBook_name(rs.getString("book_name"));
					book.setBook_no(rs.getString("book_no"));
					book.setBook_author(rs.getString("book_author"));
					book.setBook_press(rs.getString("book_press"));
					book.setBook_rest_num(rs.getInt("book_rest_num"));
					book.setBook_type_no(rs.getString("book_type_no"));
					return book;		
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}
			return null;
	}
	
	//根据借书证获得借书信息
	public ArrayList<Borrowed_book> getBorrowMsgByScardNo(String Scard_no){
		ArrayList<Borrowed_book> borrow_list=new ArrayList<Borrowed_book>();
		DBUtil db=new DBUtil();
		String sql="select * from borrowed_book where Scard_no like '%"+Scard_no+"%'";
		ResultSet rs=db.query(sql);
		try {
			while(rs.next()){
				Borrowed_book borrow=new Borrowed_book();
				borrow.setBook_no(rs.getString("book_no"));
				borrow.setBorrowed_book_time(rs.getString("borrowed_book_time"));
				borrow.setScard_no(rs.getString("Scard_no"));
				borrow.setBorrowed_book_num(rs.getString("borrowed_book_num"));
				borrow_list.add(borrow);
			}
			return borrow_list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return null;
	}
	//根据书籍编号获得借书信息
	public ArrayList<Borrowed_book> getBorrowMsgByBookNo(String book_no){
		ArrayList<Borrowed_book> borrow_list=new ArrayList<Borrowed_book>();
		DBUtil db=new DBUtil();
		String sql="select * from borrowed_book where book_no like '%"+book_no+"%'";
		ResultSet rs=db.query(sql);
		try {
			while(rs.next()){
				Borrowed_book borrow=new Borrowed_book();
				borrow.setBook_no(book_no);
				borrow.setBorrowed_book_time(rs.getString("borrowed_book_time"));
				borrow.setScard_no(rs.getString("Scard_no"));
				borrow.setBorrowed_book_num(rs.getString("borrowed_book_num"));
				borrow_list.add(borrow);
			}
			return borrow_list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	//根据借书证获得还书信息
		public ArrayList<Return_book> getReturnMsgByScardNo(String Scard_no){
			ArrayList<Return_book> return_list=new ArrayList<Return_book>();
			DBUtil db=new DBUtil();
			String sql="select * from return_book where Scard_no like '%"+Scard_no+"%'";
			ResultSet rs=db.query(sql);
			try {
				while(rs.next()){
					Return_book returnBook=new Return_book();
					returnBook.setBook_no(rs.getString("book_no"));
					returnBook.setScard_no(rs.getString("Scard_no"));
					returnBook.setReturn_book_num(rs.getString("return_book_num"));
					returnBook.setReturn_book_time(rs.getString("return_book_time"));
					return_list.add(returnBook);
				}
				return return_list;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return null;
		}
		
		//根据书籍编号获得还书信息
		public ArrayList<Return_book> getReturnMsgByBookNo(String book_no){
			ArrayList<Return_book> return_list=new ArrayList<Return_book>();
			DBUtil db=new DBUtil();
			String sql="select * from return_book where book_no like '%"+book_no+"%'";
			ResultSet rs=db.query(sql);
			try {
				while(rs.next()){
					Return_book returnBook=new Return_book();
					returnBook.setBook_no(rs.getString("book_no"));
					returnBook.setScard_no(rs.getString("Scard_no"));
					returnBook.setReturn_book_num(rs.getString("return_book_num"));
					returnBook.setReturn_book_time(rs.getString("return_book_time"));
					return_list.add(returnBook);
				}
				return return_list;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return null;
		}
}
