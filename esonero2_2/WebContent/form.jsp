<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="send" method="post">
	C1:	<input type="text" name="cu" value="${campou}">	<br>			
	C2: <input type="text" name="cd" value="${campod}"> <br>
	<input type="submit" value="invia">
</form>
${errc1 }
${errc2 }
</body>
</html>