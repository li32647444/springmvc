<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="include/head.jsp"%>
<style type="text/css">
</style>
<body class="container verticalCentering"
	style="max-width: 350px; min-height: 400px;">
	<form id="loginForm">
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
			<button id="loginBtn" type="button" class="btn btn-default" style="float: right;">登录</button>
		</div>
		<div class="form-group">
			<label for="loginByThree">第三方登录：</label> <a href="toQQLogin"><img
				src="images/qqlogin.ico" width="20px" height="20px" /></a>
		</div>
		<div class="form-group">
			<label for="loginByThree">切换登录窗口：</label> <a href="toShakeLogin">ShakeLogin</a>
		</div>
		<%-- <c:if test="${msg!=null}"> --%>
			<div class="alert alert-success" role="alert">
				<button class="close" data-dismiss="alert" type="button">&times;</button>
				<p id="msg">${msg}</p>
			</div>
		<%-- </c:if> --%>
	</form>
	<script type="text/javascript">
		$(document).ready(function() {
			/* $(".close").click(); */
			//晃动表单
			function shakeLoginForm() {
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
					shakeLoginForm();
					return;
				} else if("" == password){
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