package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.db.DBUtil;
/*
 * 增加书的类别
 */
public class do_add_booktype extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		response.setCharacterEncoding("utf-8");
		//获取表单数据
		String book_type_no=request.getParameter("book_type_no");
		String book_type_name=request.getParameter("book_type_name");
		
		
		DBUtil db=new DBUtil();
		String sql = "insert into Book_type values ('"+book_type_no+"','"+book_type_name+"')";
		db.update(sql);
		
		String loginURL = "http://localhost:8080/library/book.jsp";
		String setTime = "3";
		String say = "添加书籍类别成功！正在跳转到书籍页面";
		response.sendRedirect("goto.html?gotoURL=" + loginURL + "&setTime=" + setTime + "&say=" + java.net.URLEncoder.encode(say,"utf8"));
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
		
	}

}
