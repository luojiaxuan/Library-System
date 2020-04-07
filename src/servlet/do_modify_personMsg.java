package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.db.DBUtil;
/*
 * 修改个人信息
 */
public class do_modify_personMsg extends HttpServlet {

	
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		String Scard_no=request.getParameter("Scard_no");
		String Sname=request.getParameter("Sname");
		String Ssex=request.getParameter("Ssex");
		String  grade=request.getParameter("grade");
		String spwd=request.getParameter("Spwd");
		
		DBUtil db=new DBUtil();
		String sql="update Students set Scard_no='"+Scard_no+"',spwd='"+spwd+"'," +
				"Sname='"+Sname+"',Ssex='"+Ssex+"',grade='"+grade+"' where Scard_no='"+Scard_no+"'";
		db.update(sql);
		String loginURL = "http://localhost:8080/library/book.jsp";
		String setTime = "3";
		String say = "个人信息修改成功！";
		response.sendRedirect("goto.html?gotoURL=" + loginURL + "&setTime=" + setTime + "&say=" + java.net.URLEncoder.encode(say,"utf8"));
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	doGet(request, response);
	}

}
