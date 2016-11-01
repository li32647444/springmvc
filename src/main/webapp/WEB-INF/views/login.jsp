<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="include/head.jsp"%>
<style type="text/css">
#loginForm{
	position: relative;
	z-index: 1;
	background: #FFFFFF;
	max-width: 400px;
	margin: 0 auto 100px;
	padding: 5px 45px;
	box-shadow: 0 0 20px 0 rgba(0, 0, 0, 0.2), 0 5px 5px 0
		rgba(0, 0, 0, 0.24);
}
.form input {
	font-family: "Roboto", sans-serif;
	outline: 0;
	background: #f2f2f2;
	width: 100%;
	border: 0;
	margin: 0 0 15px;
	padding: 15px;
	box-sizing: border-box;
	font-size: 14px;
}

.form button {
	font-family: "Microsoft YaHei", "Roboto", sans-serif;
	text-transform: uppercase;
	outline: 0;
	background: #4CAF50;
	width: 100%;
	border: 0;
	padding: 15px;
	color: #FFFFFF;
	font-size: 14px;
	-webkit-transition: all 0.3 ease;
	transition: all 0.3 ease;
	cursor: pointer;
}

.form button:hover, .form button:active, .form button:focus {
	background: #43A047;
}
body {
	padding: 2% 0 0;
	margin: auto;
	background: #76b852; /* fallback for old browsers */
	background: -webkit-linear-gradient(right, #76b852, #8DC26F);
	background: -moz-linear-gradient(right, #76b852, #8DC26F);
	background: -o-linear-gradient(right, #76b852, #8DC26F);
	background: linear-gradient(to left, #76b852, #8DC26F);
	font-family: "Roboto", sans-serif;
	-webkit-font-smoothing: antialiased;
	-moz-osx-font-smoothing: grayscale;
}
</style>
<body class="container">
	<form id="loginForm" class="form">
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
		<div class="form-group text-right">
			<button id="loginBtn" type="button" class="btn btn-success">登录</button>
		</div>
		<div class="form-group">
			<label for="loginByThree">第三方登录：</label> <a href="toQQLogin"><img
				src="images/qqlogin.ico" width="20px" height="20px" /></a>
		</div>
		<div class="form-group">
			<label for="loginByThree">切换登录窗口：</label> <a href="toShakeLogin">ShakeLogin</a>
		</div>
		<div class="alert alert-success" role="alert">
			<a class="close" type="button">&times;</a>
			<p id="msg">${msg}</p>
		</div>
	</form>
	<script type="text/javascript">
		$(document).ready(function() {
			$(".alert").hide();
			$(".close").click(function() {
				$(".alert").hide();
			});
			//晃动表单
			function shakeLoginForm() {
				$(".alert").show();
				$(".alert").removeClass('shake_effect');
				setTimeout(function() {
					$(".alert").addClass('shake_effect')
				}, 1);
			}

			$("#loginBtn").click(function() {
				var username = $("#userName").val();
				var password = $("#password").val();
				if ("" == username) {
					$("#msg").html("用户名不能为空！！！");
					$("#userName").focus();
					shakeLoginForm();
					return;
				} else if("" == password){
					$("#password").focus();
					$("#msg").html("密码不能为空！！！");
					shakeLoginForm();
					return;
				}
				$.ajax({
					url : "login",
					type : "post",
					data : {"username":username,"password":password},
					success : function(data) {
						if("success" == data){
							location.href = "toIndex";
						} else {
							$("#msg").html(data);
							shakeLoginForm();
						}
					},
					error: function() {
						$("#msg").html("网络异常，请稍后操作！");
						shakeLoginForm();
			        }
				});
			});
		});
	</script>
</body>
</html>