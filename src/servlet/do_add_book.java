package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.db.DBUtil;
/*
 * 增加书本
 */
public class do_add_book extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		response.setCharacterEncoding("utf-8");
		
		String book_no=request.getParameter("book_no");
		String book_name=request.getParameter("book_name");
		String book_author=request.getParameter("book_author");
		String book_press=request.getParameter("book_press");
		String book_rest_num=request.getParameter("book_rest_num");
		String book_type_no = request.getParameter("book_type_no");
		String book_details=request.getParameter("book_details");
		String picture = request.getParameter("picture");
		
		DBUtil db=new DBUtil();
		String sql = "insert into Book values ('"+book_no+"','"+book_name+"','"+book_author+"'," +
				"'"+book_press+"','"+Integer.parseInt(book_rest_num)+"','"+book_type_no+"','"+book_details+"','"+picture+"')";
		db.update(sql);
		
		String loginURL = "http://localhost:8080/library/book.jsp";
		String setTime = "3";
		String say = "添加书籍成功！正在跳转到书籍页面";
		response.sendRedirect("goto.html?gotoURL=" + loginURL + "&setTime=" + setTime + "&say=" + java.net.URLEncoder.encode(say,"utf8"));
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
		
	}

}
