<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="it.uniroma3.model.Studente"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<ul>
	<!--  <% List<Studente> listastudenti = (List<Studente>)request.getAttribute("listastudenti");
 		for(int i = 0;i<listastudenti.size();i++) {
		String nome = (listastudenti.get(i).getNome());
		String cognome = (listastudenti.get(i).getCognome());
		Integer matricola = (listastudenti.get(i).getMatricola());
	%>
<li>
	<%out.print(nome); %>	<br>
	<%out.print(cognome); %>	<br>
	<%out.print(matricola); %>	<br>
</li>
<% } %>	-->
		<c:forEach var="studente" items="${listastudenti}">
			<li>${studente.nome} <br> 
			${studente.cognome } <br>
			${studente.matricola }
		</c:forEach>
	</ul>
</body>
</html>