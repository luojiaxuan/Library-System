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
 * 借书操作
 */
public class do_borrow_book extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		
		//设置日期格式
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date=new Date();
		
		//获取表单信息
		String Scard_no = request.getParameter("Scard_no");
		String book_no=request.getParameter("book_no");
		String borrowed_book_num=request.getParameter("borrowed_book_num");
		
		DBUtil db=new DBUtil();
		String sql = "insert into borrowed_book values ('"+book_no+"','"+Scard_no+"','"+
		Integer.parseInt(borrowed_book_num)+"','"+sdf.format(date)+"')";
		
		
		String sql1="select book_rest_num from Book where book_no='"+book_no+"'";//查询该书编号对应的书的剩余数量
		ResultSet rs=db.query(sql1);
		int	book_rest_num = 0;
		try {
			if(rs.next()){
					book_rest_num=rs.getInt("book_rest_num");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int book_num=book_rest_num-Integer.parseInt(borrowed_book_num);//剩余书数量-借走的数量
		String sql2="update Book set book_rest_num='"+book_num+"'where book_no='"+book_no+"'";
		
		String loginURL="";
		String setTime = "";
		String say="";
		//判断book_num是否大于0，以此来决定是否将书借出
		if (book_num>=0) {
			db.update(sql);
			db.update(sql2);
			loginURL = "http://localhost:8080/library/stu_library.jsp";
			say = "恭喜"+Scard_no+"借书成功！";
			response.sendRedirect("goto.html?gotoURL=" + loginURL + "&setTime=" + setTime +
					"&say=" + java.net.URLEncoder.encode(say,"utf8"));
		}else{//要借的书数目大于剩余数量
			loginURL = "http://localhost:8080/library/borrow_book.jsp";
			setTime = "10";
			say = "很抱歉，"+Scard_no+"该书剩余数目不足，请重新借书！";
			response.sendRedirect("goto.html?gotoURL=" + loginURL + "&setTime=" + setTime +
					"&say=" + java.net.URLEncoder.encode(say,"utf8"));
		}
		
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
