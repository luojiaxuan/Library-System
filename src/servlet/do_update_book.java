package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.db.DBUtil;
/*
 * 更新书籍
 */
public class do_update_book extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		String book_no=request.getParameter("book_no");
		String book_name=request.getParameter("book_name");
		String book_author=request.getParameter("book_author");
		String book_press=request.getParameter("book_press");
		String book_rest_num=request.getParameter("book_rest_num");
		String book_details=request.getParameter("book_details");
		
		DBUtil db=new DBUtil();
		String sql="update Book set book_name='"+book_name+"',book_author='"+book_author+"'," +
				"book_press='"+book_press+"',book_rest_num='"+Integer.parseInt(book_rest_num)+"',book_details='"+book_details+"' where " +
						"book_no='"+book_no+"'";
		db.update(sql);
		String loginURL = "http://localhost:8080/library/book.jsp";
		String setTime = "3";
		String say = "修改成功！";
		response.sendRedirect("goto.html?gotoURL=" + loginURL + "&setTime=" + setTime + "&say=" + java.net.URLEncoder.encode(say,"utf8"));
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
