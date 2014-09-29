<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>bkltech doc convert system</title>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
  bkltech doc convert system:
    <a href="<%=basePath%>documentUpload.jsp">get start</a>
    <!-- <a href="<%=basePath%>/js1/documentUpload.jsp">例子2</a> -->
  </body>
</html>
