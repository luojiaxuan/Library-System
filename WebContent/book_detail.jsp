<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%@ page import="DAO.BookDAO" %>
<%@ page import="com.bean.booksBean" %>
<%@page import="com.bean.Book_type"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>图书详情页</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="./css/book_detail.css">
	

  </head>
  <%
  request.setCharacterEncoding("utf-8");
   %>
  <body>
  <%
		BookDAO bookDAO = new BookDAO();
		booksBean book = bookDAO.getBookByno(request.getParameter("book_no"));
		Book_type book_type = bookDAO.getBookTypeByno(book.getBook_type_no());
	 %>
    <span class="big">图书</span>> <%=book_type.getBook_type_name() %>
	<hr>
	
	<div class="book-img">
		<img src="./images/<%=book.getPicture() %>" alt="无法加载图片资源">
	</div>
	<div class="content">
		<p class="book-name"><%=book.getBook_name() %></p>
		<p class="book-author"><%=book.getBook_author() %></p>
		书籍编号：<span class="book-no"><%=book.getBook_no() %></span>
		
		<div class="introduce"><h4>内容简介</h4></p>
		<div class="line"></div>
		<p class="book-intro"><%=book.getBook_details() %></p>
		<a href="book_detail_borrow.jsp?book_no=<%=book.getBook_no()%>" class="submit-msg">借阅</a>
		<a id="admin1" href="modify_book_msg.jsp?book_no=<%=book.getBook_no()%>" class="submit-msg">修改信息</a>
		<a id="admin2" href="javascript:mydelete();" class="submit-msg">删除该书</a>
	</div>
	</div>
  </body>
</html>
<script>
<%String adminflag=request.getSession().getAttribute("adminflag").toString();%>//通过session拿到adminflag的值
	//如果不是管理员，那么不能添加书籍也不能添加书籍类型，也不能修改书库里书的信息和删除列表中的书籍
	var adminflag = "<%=adminflag%>";
	//alert(adminflag);
	if(adminflag!="true")//非管理员账号
	{
	//非管理员
	var temp = document.getElementById("admin1");
	temp.parentNode.removeChild(temp);
	temp=document.getElementById("admin2");
	temp.parentNode.removeChild(temp);
	//document.getElementById("admin").remove();
	}
	//ajax原生对象
	function ajaxFunction() {
	    var xmlhttp;
	    if(window.XMLHttpRequest){
	    	xmlhttp=new XMLHttpRequest();
	    }
	    else{
	    	xmlhttp=new ActiveObject("Microsoft.XMLHTTP");
	    }

	    return xmlhttp;
	}
	//function $(object) {
		//return document.getElementById(object);
	//}
	//do something about deleting
	function mydelete(){
		var bookno="<%=book.getBook_no()%>";//获取编号
		//alert(bookno);
		if(confirm("请确认删除!")){
			var request = ajaxFunction();
			//request.open("GET","/do_delete_book?book_no="+bookno,true);
			request.open("POST","do_delete_book",true);
			request.setRequestHeader('Content-type','application/x-www/form-urlencoded;charset=utf-8');
			var data={
				book_no:bookno
			};
			//alert(data["book_no"]);
			var json = JSON.stringify(data);
			//alert(json);
			//request.send();
			request.send(json);
			request.onreadystatechange=function(){
				//alert(1);
				if(request.readyState==4&&request.status==200){
					var lURL = "http://localhost:8080/library/book.jsp";
					window.location.href=lURL;
				}
			}
		}
	}
	
</script>
