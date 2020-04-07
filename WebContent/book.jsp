<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
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
    
    <title>书库</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="./css/book.css">


  </head>
  
  <body>
   <header>
		
	</header>
	<div style="background:url('./images/top_backgroup.jpg');width:76.47%;height:300px;">		
			<input type="text" placeholder="请输入关键词" name="key" value="" id="key">
			<input type="button" value="高亮" name="button" id="button">
	</div>
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
		
			<table>
		    <tr>
		    
			 <td>
			<!-- 商品循环开始 -->
				<%
			 BookDAO book = new BookDAO();
		 	 ArrayList<booksBean> booklist = book.getAllBooksItem();
		 	 if(booklist!=null&&booklist.size()>0){
		 	 	for(int i=0;i<booklist.size();i++){
			 	booksBean booksBean=booklist.get(i);
			 %>
				<div class="bookitem">
					<dl>
						<dt><a href="book_detail.jsp?book_no=<%=booksBean.getBook_no()%>"><img src="./images/<%=booksBean.getPicture() %>" alt="无法加载图片资源"></a></dt>
						<dd class="content"><a href="book_detail.jsp?book_no=<%=booksBean.getBook_no()%>"><%=booksBean.getBook_name() %></a></dd>
					</dl>
				</div>
				<%
				}
			}
			 %>
			</td>
			<!-- 商品循环结束 -->
			
		</tr>
	</table>
<script>
				var contentarr=document.getElementsByTagName('dd');
				var aArr=[];
				//console.log(contentarr);
				//alert(contentarr);
				//alert("0");
				for(var i=0;i<contentarr.length;i++){
					var content=contentarr[i].getElementsByTagName('a')[0];//获取a标签内的对象
					aArr.push(contentarr[i].getElementsByTagName('a')[0]);//存入数组中
					//alert(contentarr[i].getElementsByTagName('a')[0].innerHTML);
				}
				var key = document.getElementById("key");//获取关键字
				var button = document.getElementById("button");//获取button
				button.onclick=function(){
					var value=key.value;//获得关键词文本
					//alert("关键词："+value);
					for(var j=0;j<aArr.length;j++){
						var content=aArr[j].innerHTML;//获得书籍书名内容
						//alert("书籍名："+content);
						var values = content.split(value);//按关键词分词
						//alert(values);
						aArr[j].innerHTML=values.join('<span style="background:red;">'+value+'</span>');
					}
				}
			</script>
		</div>
	</main>
  </body>
  <footer>
	<p>计科1707罗家璇版权所有</p>
	</footer>
</html>
<script>
	<%String adminflag=request.getSession().getAttribute("adminflag").toString();%>//通过session拿到adminflag的值
	//如果不是管理员，那么不能添加书籍也不能添加书籍类型，也不能修改书库里书的信息和删除列表中的书籍
	var adminflag = "<%=adminflag%>";
	//alert(adminflag);
	if(adminflag!="true")//非管理员账号
		{
		//清除掉添加书籍按钮
			document.getElementById("admin1").innerHTML="";
			document.getElementById("admin2").innerHTML="";
		}
</script>
