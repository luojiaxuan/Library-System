<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!-- 使用过渡型文档 -->
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>注册</title>
    <!-- 拒绝缓存，让页面每次进入都重新加载 -->
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!-- 调用register css样式表 -->
	<link rel="stylesheet" type="text/css" href="./css/register.css">
	

  </head>
  <%
   request.setCharacterEncoding("utf-8");
   %>
  <body>
   <main>
		<div class="container">
		<div class="logo"></div>
			<fieldset>
			<form action="doRegister" method="post">
			
			<label for="Scard_no">借书证编号：</label>
			<br>
			<input type="text" placeholder="请输入借书证编号" name="Scard_no" pattern="[0-9]{10}" title="A credit
card number is 10 digits with no spaces or dashes" required>
			<br>
			
			<label for="Spwd">密码：</label>
			<br>
			<input type="password" placeholder="请输入密码" name="Spwd" required>
			<br>
			
			<label for="Sname">姓名：</label>
				<br>
			<input type="text" placeholder="请输入姓名" name="Sname" required>
			<br>
			
			<label for="Ssex">性别：</label>
			<input type="radio" name="Ssex" value="男" >男
			<input type="radio" name="Ssex" value="女">女
			<br>
			
			<label for="grade">年级：</label>
			<!-- 复选框 -->
			<select  name="grade">
				<option value="大一">大一</option>
				<option value="大二">大二</option>
				<option value="大三">大三</option>
				<option value="大四">大四</option>
			</select>
			<br>
			<!-- 表单提交 -->
			<input type="submit" class="register" value="注册"></a>
	</form>
	</fieldset>
		</div>
	</main>
	<footer></footer>
  </body>
</html>
