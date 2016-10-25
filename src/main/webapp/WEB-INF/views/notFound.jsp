<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="include/head.jsp"%>
<body>
	<center>
		<b>访问的页面不存在！</b><br />
		<script language="javascript">
			function go() {
				window.history.go(-1);
			}
			setTimeout("go()", 5000);
			var leftTime = 4;
			function subTime() {
				$("#leftTime").html(leftTime);
				leftTime--;
				setTimeout("subTime()", 1000);
			}
			setTimeout("subTime()", 1000);
		</script>
		<input type="button" name="Submit"
			onclick="javascript:history.back(-1);" value="返回上一页" /><br /> <b>页面将在<span
			id="leftTime">5</span>秒后返回...
		</b>
	</center>
</body>
</html>