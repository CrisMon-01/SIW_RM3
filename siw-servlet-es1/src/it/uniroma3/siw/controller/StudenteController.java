package it.uniroma3.siw.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/studente")	// :   /+rif a form action
public class StudenteController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException{
		String nome = request.getParameter("nome");	//fatto da appl. server
		String cognome = request.getParameter("cognome");
		String matricola = request.getParameter("matricola");
		
		nome=nome.toUpperCase();	//in maiuscolo x uniformare il testo e evitare KeySense
		cognome=cognome.toUpperCase();
		
		nome = nome.trim();			//elimino whitespace init e fine
		cognome = cognome.trim();
		matricola=matricola.trim();
		
		// leggo (alcune) intestazioni http della richiesta
		String address = (String)request.getRemoteAddr();
		String host = (String)request.getRemoteHost();
		String userAgent = request.getHeader("User-Agent");
		
		response.setContentType("text/html");	//tipo risposta
		
		PrintWriter out = response.getWriter();		
		
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
		out.println("<br />IP: <b>"+address+"</b>");
		out.println("<br />Host: <b>"+host+"</b>");
		out.println("<br />User Agent: <b>"+userAgent+"</b>");
		out.println("</body>\n</html> ");
		
	}
}
