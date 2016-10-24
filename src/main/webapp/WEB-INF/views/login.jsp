<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
<title>登录</title>
<!-- Bootstrap -->
<link
	href="<%=request.getContextPath()%>/plugins/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body class="container" style="width: 300px; margin-top: 100px;">
	<h1 class="text-center">登录</h1>
	<form action="login" id="loginForm" method="post">
		<input type="hidden" id="location" name="location">
		<div class="form-group">
			<label for="exampleInputUserName">邮箱/用户名/手机号：</label> <input
				type="text" class="form-control" id="userName"
				placeholder="UserName" name="username">
		</div>
		<div class="form-group">
			<label for="exampleInputPassword">密码：</label> <input type="password"
				class="form-control" id="password" placeholder="Password"
				name="password">
		</div>
		<div class="form-group">
			<button type="button" class="btn btn-default" style="float: right;"
				onclick="login()">登录</button>
		</div>
		<div class="form-group">
			<label for="loginByThree">第三方登录：</label> <a href="toQQLogin"><img
				src="images/qqlogin.ico" width="20px" height="20px" /></a>
		</div>
	</form>
	<c:if test="${msg!=null}">
		<div class="alert alert-success" role="alert">
			<button class="close" data-dismiss="alert" type="button">&times;</button>
			<p>${msg}</p>
		</div>
	</c:if>

	<script
		src="<%=request.getContextPath()%>/plugins/bootstrap/js/jquery-1.10.2.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script
		src="<%=request.getContextPath()%>/plugins/bootstrap/js/bootstrap.min.js"></script>
	<script type="text/javascript">
		function login() {
			$("#loginForm").submit();
		}
	</script>
</body>
</html>