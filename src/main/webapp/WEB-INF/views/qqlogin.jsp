<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Index.jsp</title>
	<!-- base需要放到head中 -->    
    <base href="<%=basePath%>">   
</head>
<body>
	<center style="margin-top: 200px;">
		<img alt="" src="images/qq_login.png" />
	</center>
</body>
</html>