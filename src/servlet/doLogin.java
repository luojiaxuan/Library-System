package servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.db.DBUtil;

/*
 * 读者登陆操作	
 */
	public class doLogin extends HttpServlet {

		public void doGet(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			String Scard_no = request.getParameter("Scard_no");//获取借书卡编号
			String Spwd = request.getParameter("Spwd");//获取密码
			String adminflag="false";
			//System.out.println(Scard_no);
			//System.out.println(Spwd);
			DBUtil db = new DBUtil();
			String sql ="select * from Students where Scard_no='"+Scard_no+"' and Spwd ='"+Spwd+"'";
		 	ResultSet rs = db.query(sql);
		 	try {
				if(rs.next()){
					adminflag = rs.getString("adminflag").toString();
					//System.out.print(adminflag); true
					request.getSession().setAttribute("adminflag",adminflag);
					request.getSession().setAttribute("Scard_no", Scard_no);
					request.getRequestDispatcher("stu_library.jsp").forward(request, response);
				}else{
					//StudentLogin.setLogined(false);
					response.sendRedirect("login_failed.jsp");	
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
				
		}
		public void doPost(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {

			doGet(request,response);
		}

}
