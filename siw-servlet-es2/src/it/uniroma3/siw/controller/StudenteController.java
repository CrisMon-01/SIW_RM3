package it.uniroma3.siw.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/prendidati")	// :   /+rif a form action
public class StudenteController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException{
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
		
		request.setAttribute("address", address);
		request.setAttribute("host", host);
		request.setAttribute("userAgent", userAgent);
		
		request.setAttribute("nome", nome);
		request.setAttribute("cognome", cognome);
		
		ServletContext app = getServletContext();
		RequestDispatcher rd = app.getRequestDispatcher("/processa");
		rd.forward(request, response);
		return;
		
	}
}
