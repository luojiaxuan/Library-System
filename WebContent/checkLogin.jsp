<%@ page language="java" import="java.util.*,java.sql.*" contentType="text/html; charset=utf-8"%>
<%@ page import="com.db.DBUtil" %>
<%@ page import="com.bean.StudentsBean" %>

<jsp:useBean id="StudentLogin" class="com.bean.StudentsBean" scope="session"></jsp:useBean>
<jsp:useBean id="myDBbean" class="com.db.DBUtil" scope="session"/>
<jsp:setProperty name="StudentLogin" property="*" />
<%
request.setCharacterEncoding("utf-8");
 %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<%
	 
	String Scard_no = StudentLogin.getScard_no();
	 String Spwd = StudentLogin.getSpwd();
	 System.out.print(Scard_no);
	 System.out.print(Spwd);
	 
	 //String sql ="select * from Students where Scard_no='0902170501' and Spwd='123456'";
	 String sql ="select * from Students where Scard_no='"+StudentLogin.getScard_no()+"' and Spwd ='"+StudentLogin.getSpwd()+"'";
	 	ResultSet rs = myDBbean.query(sql);
	 	if(rs.next()){
	 		StudentLogin.setLogined(true);
	 		session.setAttribute("Scard_no", StudentLogin.getScard_no());
	 		request.getRequestDispatcher("login_success.jsp").forward(request, response);
	 	}else{
	 		StudentLogin.setLogined(false);
	 		response.sendRedirect("login_failed.jsp");
	 		
	} 
 %>
