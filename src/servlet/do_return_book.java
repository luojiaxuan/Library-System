package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.db.DBUtil;
/*
 * 还书操作
 */
public class do_return_book extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

response.setContentType("text/html");
		
		//设置日期格式
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date=new Date();
		
		//从表单中获取数据
		String Scard_no = request.getParameter("Scard_no");
		String book_no=request.getParameter("book_no");
		String return_book_num=request.getParameter("return_book_num");
		
		
		DBUtil db=new DBUtil();
		//往还书表中插入一条数据
		String sql = "insert into return_book values ('"+book_no+"','"+Scard_no+"','"+
		Integer.parseInt(return_book_num)+"','"+sdf.format(date)+"')";
		
		String loginURL ="";
		String setTime = "5";
		String say ="";
		String sql3="select * from borrowed_book where book_no='"+book_no+"' and Scard_no='"+Scard_no+"'";//查询借书表中此书籍编号的记录
		ResultSet rs1=db.query(sql3);//从借书表中获取记录
		try {
			if(rs1.next()){
				db.update(sql);//如果借书的表中有结果此借书证借这本书的记录，才可执行还书的记录插入。
				String sql1="select book_rest_num from Book where book_no='"+book_no+"'";//查询该书籍编号对应的书记剩余书的数量
				ResultSet rs=db.query(sql1);
				int	book_rest_num = rs.getInt("book_rest_num");
				
				int book_num=book_rest_num+Integer.parseInt(return_book_num);//该书籍编号对应的书籍剩余的书数量+要还的该书数量
				String sql2="update Book set book_rest_num='"+book_num+"'where book_no='"+book_no+"'";
				db.update(sql2);//更新书籍表里该书的数量
				
				loginURL = "http://localhost:8080/library/book.jsp";
				say = "恭喜"+Scard_no+"还书成功！";
				response.sendRedirect("goto.html?gotoURL=" + loginURL + "&setTime=" + setTime + "&say=" + java.net.URLEncoder.encode(say,"utf8"));
				
			}else {
				loginURL = "http://localhost:8080/library/return_book.jsp";
				say = "很抱歉，"+Scard_no+"您没有借过此书";
				response.sendRedirect("goto.html?gotoURL=" + loginURL + "&setTime=" + setTime + "&say=" + java.net.URLEncoder.encode(say,"utf8"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	}


	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
