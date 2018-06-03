package it.uniroma3.model;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/studente")
public class StudenteController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String nome = req.getParameter("nome");
		String cognome = req.getParameter("cognome");
		String matricola = req.getParameter("matricola");

		String ip = req.getRemoteAddr();
		String host = req.getRemoteHost();
		String useragent = req.getHeader("User-Agent");

		resp.setContentType("text/html");	//tipo risposta

		PrintWriter out = resp.getWriter();		

		out.println("<!DOCTYPE html>"); out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"ISO-8859-1\" />");
		out.println("<title>mostra parametri</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>Dati inseriti nella form</h1>");
		out.println("<ul>");
		out.println("<li>Nome: <b>"+nome+"</b></li>");
		out.println("<li>Cognome: <b>"+cognome+"</b></li>");
		out.println("<li>Matricola: <b>"+matricola+"</b></li>");
		out.println("</ul>");
		out.println("<h1>Altri dati relativi alla richiesta</h1>");
		out.println("<br />IP: <b>"+ip+"</b>");
		out.println("<br />Host: <b>"+host+"</b>");
		out.println("<br />User Agent: <b>"+useragent+"</b>");
		out.println("</body>\n</html> ");

	}
}
