<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="include/head.jsp"%>

<body class="container" style="width: 300px;">
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
	</form>
	<c:if test="${msg!=null}">
		<div class="alert alert-success" role="alert">
			<button class="close" data-dismiss="alert" type="button">&times;</button>
			<p>${msg}</p>
		</div>
	</c:if>
	<script type="text/javascript">
		function login() {
			$("#loginForm").submit();
		}
		/* $(window).resize(function(){ 
		    $("#loginForm").css({ 
		        position: "absolute", 
		        left: ($(window).width() - $("#loginForm").outerWidth())/2, 
		        top: ($(window).height() - $("#loginForm").outerHeight())/2-200
		    });        
		}); 
		$(function(){ 
		    $(window).resize(); 
		});  */
	</script>
</body>
</html>