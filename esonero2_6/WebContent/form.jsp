<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="processa" method="post">
		<input type="text" name="nome" value="${nome }">
		${errnome }	<br>
		<input type="text" name="codice" value="${codice }">
		${errcod } <br>
		<input type="submit" value="sendto">
	</form>

</body>
</html>