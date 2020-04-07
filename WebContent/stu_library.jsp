<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>学生图书管理系统</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="./css/stu_library.css">
  </head>
  
  <body>
   <header>
   <img src="./images/top_backgroup.jpg" alt="无法加载图片资源">
	</header>
	<div class="mydiv">
	<ul>
		<li>
		<a href="stu_library.jsp">首页</a>
			<ul class="second-ul">
				<li><a href="register.jsp">注册</a></li>
			</ul>
		</li>
		<li>
		<a href="stu_library.jsp">书籍借阅</a>
			<ul class="second-ul">
				<li><a href="book.jsp">查看书库</a></li>
				<li><a href="query_borrow.jsp">借书查询</a></li>
				<li><a href="query_return.jsp">还书查询</a></li>		
			</ul>
		</li>
		<li>
		<a href="stu_library.jsp">书籍管理</a>
			<ul class="second-ul">
				<li><a href="query_book.jsp">书籍查询</a></li>
				<li id="admin1"><a href="add_book.jsp">添加书籍</a></li>
				<li id="admin2"><a href="add_book_type.jsp">添加书类别</a></li>
			</ul>
		</li>
		<span class="exit">
		<a href="person_msg.jsp?Scard_no=<%=request.getSession().getAttribute("Scard_no") %>" title="查看个人资料">(<%=request.getSession().getAttribute("Scard_no")%>)</a>
		<a href="login.jsp">退出</a>
		</span>
	</ul>
	</div>
	<main>
		<div class="container">
			<div class="logo"></div>
			<div class="content">
				<div class="say">欢迎来到学生图书馆，我要<a href="borrow_book.jsp">借书</a>或<a href="return_book.jsp">还书</a>！</div>
			</div>
		</div>
	</main>
	<footer>
	<p>计科1707罗家璇版权所有</p>
	</footer>
  </body>
  
</html>
<script>
	<%String adminflag=request.getSession().getAttribute("adminflag").toString();%>//通过session拿到adminflag的值
	//如果不是管理员，那么不能添加书籍也不能添加书籍类型，也不能修改书库里书的信息和删除列表中的书籍
	var adminflag = <%=adminflag%>;
	adminflag=adminflag.toString();
	//alert(adminflag);
	if(adminflag!='true')//非管理员账号
		{
		//清除掉添加书籍按钮
			document.getElementById("admin1").innerHTML="";
			document.getElementById("admin2").innerHTML="";
		}
</script>