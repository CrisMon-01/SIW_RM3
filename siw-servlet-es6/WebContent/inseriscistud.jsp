<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="inserisci" method="post">
		Nome: <input type="text" name="nome" value="${param['nome']}">	<br>
		Codice: <input type="text" name="codice" value="${param['codice']}">	<br>
		<input type="submit" value="invia" name="send">	<br>
	</form>
	${errnome} <br>
	${errcod}

</body>
</html>