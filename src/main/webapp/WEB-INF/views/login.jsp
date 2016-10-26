<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="include/head.jsp"%>

<body class="container verticalCentering"
	style="max-width: 350px; min-height: 400px;">
	<form action="login" id="loginForm" method="post">
		<h1 class="text-center">登录</h1>
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
		<c:if test="${msg!=null}">
			<div class="alert alert-success" role="alert">
				<button class="close" data-dismiss="alert" type="button">&times;</button>
				<p id="msg">${msg}</p>
			</div>
		</c:if>
	</form>
	<script type="text/javascript">
		function login() {
			/* if ("" == $("#userName").val()) {
				$("#msg").html("用户名不能为空！！！");
				$("#close").alert("close");
				return;
			} else if("" == $("#password").val()){
				$("#msg").html("密码不能为空！！！");
				$("#close").alert("close");
				return;
			} */
			$("#loginForm").submit();
		}
	</script>
</body>
</html>