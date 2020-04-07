<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%@ page import="com.db.DBUtil" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.io.IOException" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="DAO.BookDAO" %>
<%@ page import="com.bean.booksBean" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>修改信息</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="./css/add_book.css">
	

  </head>
 <%
    request.setCharacterEncoding("utf-8");
    String book_no=request.getParameter("book_no").toString();
    DBUtil db = new DBUtil();
    String sql ="select * from Book where book_no="+book_no;
    
	ResultSet rs = db.query(sql);
	booksBean book = new booksBean();
	try {
		if(rs.next()){
			//拿到对应的书对象
			
			book.setBook_name(rs.getString("book_name"));
			book.setPicture(rs.getString("picture"));
			book.setBook_no(rs.getString("book_no"));
			book.setBook_author(rs.getString("book_author"));
			book.setBook_press(rs.getString("book_press"));
			book.setBook_rest_num(rs.getInt("book_rest_num"));
			book.setBook_type_no(rs.getString("book_type_no"));
			book.setBook_details(rs.getString("book_details"));
		}else{
			//do nothing
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
   %>
  <body>
   <main>
		<div class="container">
		<div class="logo"></div>
			<fieldset>
			<form action="do_update_book" method="post">
				<label for="book_no">书籍编号：</label>
				<br>
			<input type="text" placeholder="请输入书籍编号" name="book_no" value=<%=request.getParameter("book_no")%> required>
			<br>
			<label for="book_name">书籍名称：</label>
			<br>
			<input type="text" placeholder="请输入书籍名称" name="book_name" value=<%=book.getBook_name()%> required>
			<br>
			<label for="book_author">书籍作者：</label>
			<br>
			<input type="text" placeholder="请输入书籍作者" name="book_author" value=<%=book.getBook_author() %> required>
			<br>
			<label for="book_press">书籍出版社：</label>
			<input type="text" placeholder="请输入书籍出版社" name="book_press" value=<%=book.getBook_press() %> required>
				<br>
			<label for="book_rest_num">书籍数量：</label>
			<input type="number" placeholder="请输入书籍数量" name="book_rest_num" value=<%=book.getBook_rest_num()%> required>
			<br>
			<label for="book_type_no">书籍类型编号：</label>
			<input type="text" placeholder="请输入书籍类型编号" name="book_type_no" value=<%=book.getBook_type_no()%> required>
			<br>
			
			<label for="book_details">书籍简介：</label>
				<br>
			<input type="text" placeholder="请输入书籍简介" name="book_details" value=<%=book.getBook_details() %> required>
			<br>
			<br>
			<input type="submit" class="register" value="修改">
			<a href="book.jsp" class="register">返回</a>
	</form>
	</fieldset>
		</div>
	</main>
	<footer>
	<p>计科1707罗家璇版权所有</p>
	</footer>
  </body>
</html>
