<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/head.jsp"%>
<style type="text/css">
/* <!--为表单添加下面的必要CSS样式：--> */
/* @import url(https://fonts.googleapis.com/css?family=Roboto:300); */

.login-page {
	width: 360px;
	padding: 8% 0 0;
	margin: auto;
}

.form {
	position: relative;
	z-index: 1;
	background: #FFFFFF;
	max-width: 360px;
	margin: 0 auto 100px;
	padding: 45px;
	text-align: center;
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

.form .message {
	margin: 15px 0 0;
	color: #b3b3b3;
	font-size: 12px;
}

.form .message a {
	color: #4CAF50;
	text-decoration: none;
}

.form .register-form {
	display: none;
}

.container {
	position: relative;
	z-index: 1;
	max-width: 300px;
	margin: 0 auto;
}

.container:before, .container:after {
	content: "";
	display: block;
	clear: both;
}

.container .info {
	margin: 50px auto;
	text-align: center;
}

.container .info h1 {
	margin: 0 0 15px;
	padding: 0;
	font-size: 36px;
	font-weight: 300;
	color: #1a1a1a;
}

.container .info span {
	color: #4d4d4d;
	font-size: 12px;
}

.container .info span a {
	color: #000000;
	text-decoration: none;
}

.container .info span .fa {
	color: #EF3B3A;
}

body {
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
<body>
	<div id="wrapper" class="login-page">
		<div id="login_form" class="form">
			<form class="register-form">
				<input type="text" placeholder="用户名" id="r_user_name" /> <input
					type="password" placeholder="密码" id="r_password" /> <input
					type="text" placeholder="电子邮件" id="r_emial" />
				<button id="create">创建账户</button>
				<p class="message">
					已经有了一个账户? <a href="javascript:void(0);">立刻登录</a>
				</p>
			</form>
			<form class="login-form">
				<input type="text" placeholder="用户名" id="user_name" /> <input
					type="password" placeholder="密码" id="password" />
				<button id="login">登 录</button>
				<p class="message">
					还没有账户? <a href="javascript:void(0);">立刻创建</a>
				</p>
			</form>
		</div>
	</div>
	<script type="text/javascript">
		//两个用于验证的方法：check_login()和check_register()，分别用于验证用户登录和用户注册。
		function check_login() {
			var name = $("#user_name").val();
			var pass = $("#password").val();
			if (name == "123" && pass == "123") {
				alert("登录成功！");
				$("#user_name").val("");
				$("#password").val("");
			} else {
				$("#login_form").removeClass('shake_effect');
				setTimeout(function() {
					$("#login_form").addClass('shake_effect')
				}, 1);
			}
		}
		function check_register() {
			var name = $("#r_user_name").val();
			var pass = $("#r_password").val();
			var email = $("r_email").val();
			if (name != "" && pass == "" && email != "") {
				alert("注册成功！");
				$("#user_name").val("");
				$("#password").val("");
			} else {
				$("#login_form").removeClass('shake_effect');
				setTimeout(function() {
					$("#login_form").addClass('shake_effect')
				}, 1);
			}
		}
		//在用户点击登录和注册按钮时分别执行以上两个函数。
		$("#create").click(function() {
			check_register();
			return false;
		})
		$("#login").click(function() {
			check_login();
			return false;
		})
		//表单的切换通过jQuery的animate()方法来实现：
		$('.message a').click(function() {
			$('form').animate({
				height : 'toggle',
				opacity : 'toggle'
			}, 'slow');
		});
	</script>
</body>
</html>