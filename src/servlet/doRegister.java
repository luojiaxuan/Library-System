package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.db.DBUtil;
import com.microsoft.sqlserver.jdbc.SQLServerException;
//使用http协议，专门处理http请求
public class doRegister extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		final PrintWriter out=response.getWriter();
		//防止输出中文乱码
		 response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		response.setHeader("content-type", "text/html;charset=UTF-8");   
		request.setCharacterEncoding("UTF-8");  
		
		String Scard_no=request.getParameter("Scard_no");
		String Spwd=request.getParameter("Spwd");
		String Sname=request.getParameter("Sname");
		String Ssex=request.getParameter("Ssex");
		String grade=request.getParameter("grade");
		String adminflag = "false";
		
			DBUtil db = new DBUtil();
			String sql="insert into Students values(?,?,?,?,?,?)";
			String msg[] = {Scard_no,Spwd,Sname,Ssex,grade,adminflag};
			db.update(sql,msg);
			String loginURL = "http://localhost:8080/library/login.jsp";
			String setTime = "5";
			String say = "恭喜"+Sname+"注册成功！";
			response.sendRedirect("goto.html?gotoURL=" + loginURL + "&setTime=" + setTime + "&say=" + java.net.URLEncoder.encode(say,"utf8"));
		
	}	

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
