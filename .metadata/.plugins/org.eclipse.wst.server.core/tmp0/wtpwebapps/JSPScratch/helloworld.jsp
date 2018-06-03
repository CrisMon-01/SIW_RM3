<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Hello World</h2>
	The time time on the server is <%= new Date() %>	<!-- EXPRESSION -->
	Stringa maiuscola <%= new String("HelloWorld").toUpperCase() %>	<br>
	risultato calcolato in java di 3 + 2 : <%= 3+2 %>
</body>
</html>